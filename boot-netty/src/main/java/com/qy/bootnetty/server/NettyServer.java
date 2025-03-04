package com.qy.bootnetty.server;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NettyServer implements CommandLineRunner {

    @Autowired
    private ChannelFuture channelFuture;

    @Override
    public void run(String... args) throws Exception {
        channelFuture.channel().closeFuture().sync();
    }
}