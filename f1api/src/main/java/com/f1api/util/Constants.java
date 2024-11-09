package com.f1api.util;
public class Constants {
    public static final class PacketTypes {
        public static final String MOTION_PACKET = "motionPacketData";
        public static final String LAP_DATA_PACKET = "lapDataPacketData";
        public static final String CAR_TELEMETRY_PACKET = "carTelemetryPacketData";
        public static final String MOTION_EX_PACKET = "motionExPacketData";
    }

    public static final class CornerSides {
        public static final Short RL = 0;
        public static final Short RR = 1;
        public static final Short FL = 2;
        public static final Short FR = 3;
    }
}
