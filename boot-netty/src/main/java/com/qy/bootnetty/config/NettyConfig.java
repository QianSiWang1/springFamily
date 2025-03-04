package com.qy.bootnetty.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfig {

    @Value("${netty.port}")
    private int port;

    @Bean(destroyMethod = "shutdownGracefully")
    public EventLoopGroup bossGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public EventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public ServerBootstrap bootstrap(EventLoopGroup bossGroup, EventLoopGroup workerGroup) {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        // 可以在这里添加ChannelHandler

                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() { // 自定义 handler
                            @Override // 读事件
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                                ctx.writeAndFlush(msg); // 打印上一步转换好的字符串
                            }
                        });
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        return b;
    }

    @Bean
    public ChannelFuture start(ServerBootstrap bootstrap) throws InterruptedException {
        ChannelFuture f = bootstrap.bind(port).sync();
        return f;
    }
}