package com.f1api.util;

import java.util.List;

import com.f1api.entity.mongo.packet.cartelemetry.CarTelemetryDataEntity;
import com.f1api.entity.mongo.packet.lapdata.LapDataEntity;
import com.f1api.entity.mongo.packet.motion.CarMotionDataEntity;
import com.f1api.entity.mongo.packet.motionex.PacketMotionExDataEntity;

public class Constants {
    public static final class PacketTypes {
        public static final String MOTION_PACKET = "motionPacketData";
        public static final String LAP_DATA_PACKET = "lapDataPacketData";
        public static final String CAR_TELEMETRY_PACKET = "carTelemetryPacketData";
        public static final String MOTION_EX_PACKET = "motionExPacketData";
        public static final String CAR_SETUP_PACKET = "carSetupPacketData";
        public static final String CAR_STATUS_PACKET = "carStatusPacketData";
    }

    public static final class CornerSides {
        public static final Short RL = 0;
        public static final Short RR = 1;
        public static final Short FL = 2;
        public static final Short FR = 3;
    }

    public static final class PacketId {
        public static final Short MOTION_PACKET = 0;
        public static final Short LAP_DATA_PACKET = 2;
        public static final Short CAR_SETUP_PACKET = 5;
        public static final Short CAR_TELEMETRY_PACKET = 6;
        public static final Short CAR_STATUS_PACKET = 7;
        public static final Short MOTION_EX_PACKET = 13;
    }

    public static final class Url {
        public static final String GENERATE_GRAPHIC = "http://localhost:5000/generate-graphic";
        public static final String GENERATE_LAT_ACC_TIMES_GRAPHIC = "http://localhost:5000/acc-lat-graphic";
    }

    public static final class Entities {
        public static final Class<?> CAR_TELEMETRY_DATA_ENTITY = CarTelemetryDataEntity.class;
        public static final Class<?> LAP_DATA_ENTITY = LapDataEntity.class;
        public static final Class<?> CAR_MOTION_ENTITY = CarMotionDataEntity.class;
        public static final Class<?> CAR_MOTION_EX_ENTITY = PacketMotionExDataEntity.class;
        public static final List<Class<?>> NAME_LIST = List.of(
            CAR_TELEMETRY_DATA_ENTITY, 
            LAP_DATA_ENTITY, 
            CAR_MOTION_ENTITY,
            CAR_MOTION_EX_ENTITY);
    }

    public static final String PACKET_HEADER_ENTITY_STRING = "packetHeaderEntity";

    public static final String CAR_TELEMETRY_ENTITY_STRING = "CarTelemetryDataEntity";
    public static final String LAP_DATA_ENTITY_STRING = "LapDataEntity";
    public static final String CAR_MOTION_ENTITY_STRING = "CarMotionDataEntity";
    public static final String CAR_MOTION_EX_ENTITY_STRING = "PacketMotionExDataEntity";

    public static final String TIME = "t";
    public static final String DISTANCE = "d";
}
