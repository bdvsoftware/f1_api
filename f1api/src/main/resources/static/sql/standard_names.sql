ALTER TABLE drivers
  CHANGE driverId    driver_id    int          NOT NULL,
  CHANGE driverRef   driver_ref   varchar(255) NULL:

ALTER TABLE circuits
  CHANGE id    circuit_id    int          NOT NULL;

ALTER TABLE constructor_results
  CHANGE constructorResultsId constructor_results_id int NOT NULL,
  CHANGE raceId               race_id               int NOT NULL,
  CHANGE constructorId        constructor_id        int NOT NULL;

ALTER TABLE constructor_standings
  CHANGE constructorStandingsId constructor_standings_id int NOT NULL,
  CHANGE raceId                 race_id                 int NOT NULL,
  CHANGE constructorId          constructor_id          int NOT NULL,
  CHANGE points                 points                 float NULL,
  CHANGE position               position               int NULL,
  CHANGE positionText           position_text           varchar(255) NULL,
  CHANGE wins                   wins                   int NULL;

ALTER TABLE constructors
  CHANGE constructorId  constructor_id  int NOT NULL,
  CHANGE constructorRef constructor_ref varchar(255) NULL,
  CHANGE name           name           varchar(255) NULL,
  CHANGE nationality    nationality    varchar(255) NULL,
  CHANGE url            url            varchar(255) NULL;

ALTER TABLE driver_standings
  CHANGE driverStandingsId driver_standings_id int NOT NULL,
  CHANGE raceId            race_id             int NOT NULL,
  CHANGE driverId          driver_id           int NOT NULL,
  CHANGE points            points              float NULL,
  CHANGE position          position            int NULL,
  CHANGE positionText      position_text       varchar(255) NULL,
  CHANGE wins              wins                int NULL;


ALTER TABLE lap_times
  CHANGE raceId       race_id       int NOT NULL,
  CHANGE driverId     driver_id     int NOT NULL,
  CHANGE lap          lap          int NULL,
  CHANGE position     position     int NULL,
  CHANGE time         time         varchar(255) NULL,
  CHANGE milliseconds milliseconds int NULL;

ALTER TABLE pit_stops
  CHANGE raceId       race_id       int NOT NULL,
  CHANGE driverId     driver_id     int NOT NULL,
  CHANGE stop         stop          int NULL,
  CHANGE lap          lap           int NULL,
  CHANGE time         time          varchar(255) NULL,
  CHANGE duration     duration      varchar(255) NULL,
  CHANGE milliseconds milliseconds int NULL;

ALTER TABLE qualifying
  CHANGE qualifyId     qualifying_id     int NOT NULL,
  CHANGE raceId        race_id           int NOT NULL,
  CHANGE driverId      driver_id         int NOT NULL,
  CHANGE constructorId constructor_id    int NULL,
  CHANGE number        number            int NULL,
  CHANGE position      position          int NULL,
  CHANGE q1            q1                varchar(255) NULL,
  CHANGE q2            q2                varchar(255) NULL,
  CHANGE q3            q3                varchar(255) NULL;

ALTER TABLE races
  CHANGE raceId      race_id        int NOT NULL,
  CHANGE year        year           int NULL,
  CHANGE round       round          int NULL,
  CHANGE circuitId   circuit_id     int NULL,
  CHANGE name        name           varchar(255) NULL,
  CHANGE date        date           date NULL,
  CHANGE time        time           varchar(255) NULL,
  CHANGE url         url            varchar(255) NULL,
  CHANGE fp1_date    fp1_date       date NULL,
  CHANGE fp1_time    fp1_time       varchar(255) NULL,
  CHANGE fp2_date    fp2_date       date NULL,
  CHANGE fp2_time    fp2_time       varchar(255) NULL,
  CHANGE fp3_date    fp3_date       date NULL,
  CHANGE fp3_time    fp3_time       varchar(255) NULL,
  CHANGE quali_date  quali_date     date NULL,
  CHANGE quali_time  quali_time     varchar(255) NULL,
  CHANGE sprint_date sprint_date    date NULL,
  CHANGE sprint_time sprint_time    varchar(255) NULL;

ALTER TABLE results
  CHANGE resultId        result_id           int NOT NULL,
  CHANGE raceId          race_id             int NOT NULL,
  CHANGE driverId        driver_id           int NOT NULL,
  CHANGE constructorId   constructor_id      int NOT NULL,
  CHANGE number          number              float NULL,
  CHANGE grid            grid                int NULL,
  CHANGE position        position            float NULL,
  CHANGE positionText    position_text       varchar(255) NULL,
  CHANGE positionOrder   position_order      int NULL,
  CHANGE points          points              float NULL,
  CHANGE laps            laps                int NULL,
  CHANGE time            time                varchar(255) NULL,
  CHANGE milliseconds    milliseconds        float NULL,
  CHANGE fastestLap      fastest_lap         float NULL,
  CHANGE ranking         ranking             float NULL,
  CHANGE fastestLapTime  fastest_lap_time    varchar(255) NULL,
  CHANGE fastestLapSpeed fastest_lap_speed   float NULL,
  CHANGE statusId        status_id           int NULL;

ALTER TABLE sprint_results
  CHANGE resultId       result_id          int NOT NULL,
  CHANGE raceId         race_id            int NOT NULL,
  CHANGE driverId       driver_id          int NOT NULL,
  CHANGE constructorId  constructor_id     int NOT NULL,
  CHANGE number         number             int NULL,
  CHANGE grid           grid               int NULL,
  CHANGE position       position           float NULL,
  CHANGE positionText   position_text      varchar(255) NULL,
  CHANGE positionOrder  position_order     int NULL,
  CHANGE points         points             int NULL,
  CHANGE laps           laps               int NULL,
  CHANGE time           time               varchar(255) NULL,
  CHANGE milliseconds   milliseconds       float NULL,
  CHANGE fastestLap     fastest_lap        float NULL,
  CHANGE fastestLapTime fastest_lap_time   varchar(255) NULL,
  CHANGE statusId       status_id          int NULL;

ALTER TABLE status
  CHANGE statusId       status_id          int NOT NULL;

ALTER TABLE drivers
  CHANGE driverId    driver_id    int NOT NULL,
  CHANGE driverRef   driver_ref   varchar(255) NULL,
  CHANGE number      number       float NULL,
  CHANGE code        code         varchar(255) NULL,
  CHANGE forename    forename      varchar(255) NULL,
  CHANGE surname     surname      varchar(255) NULL,
  CHANGE dob         dob          date NULL,
  CHANGE nationality nationality  varchar(255) NULL,
  CHANGE url         url          varchar(255) NULL;
