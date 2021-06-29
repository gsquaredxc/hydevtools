package com.gsquaredxc.hydevtools.features;

import com.gsquaredxc.hyskyAPI.annotations.EventListener;
import com.gsquaredxc.hyskyAPI.events.packets.PacketSendEvent;
import com.gsquaredxc.hyskyAPI.events.packets.SingleBlockChangeInEvent;
import com.gsquaredxc.hyskyAPI.events.packets.TimePacketInEvent;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;

public class hdmining {

    private static long tickNum = 0;

    private static long timeLastTimeUpdate = System.nanoTime();

    private static BlockPos pos;

    @EventListener(id = "DTHMMiningPacket")
    public static boolean onSendMining(PacketSendEvent event){
        if (event.originalPacket instanceof C07PacketPlayerDigging) {
            C07PacketPlayerDigging packet = (C07PacketPlayerDigging)event.originalPacket;
            if (packet.getStatus() == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK){
                System.out.println("Start: "+  + tickNum + " System : " + System.nanoTime()+ " est ticks: " + (int)(tickNum + ((System.nanoTime() - timeLastTimeUpdate) / 5E7)));
                pos = packet.getPosition();
            }
        }
        return false;
    }

    @EventListener(id = "DTHMTickPacket")
    public static boolean onTickPacket(TimePacketInEvent packet){
        tickNum = packet.worldTime;
        double timeElapsed = (System.nanoTime() - timeLastTimeUpdate) / 1E9;
        System.out.println(packet.worldTime + " System : " + timeElapsed + " (should be 1)");
        timeLastTimeUpdate = System.nanoTime();
        return false;
    }

    @EventListener(id = "DTHMBlockChangePacket")
    public static boolean onFUCK(SingleBlockChangeInEvent event){
        if (pos.equals(event.pos)) {
            System.out.println("End: " + tickNum +" System : " + System.nanoTime() + " est ticks " + (int)(tickNum + ((System.nanoTime() - timeLastTimeUpdate) / 5E7)));
        }
        return false;
    }
}
