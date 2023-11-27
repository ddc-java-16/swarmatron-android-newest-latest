-- Generated 2023-11-26 18:24:58-0700 for database version 1

CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`
    INTEGER
    PRIMARY
    KEY
    AUTOINCREMENT
    NOT
    NULL,
    `created`
    INTEGER
    NOT
    NULL,
    `display_name`
    TEXT
    NOT
    NULL
    COLLATE
    NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_display_name` ON `user` (`display_name`);

CREATE TABLE IF NOT EXISTS `preset`
(
    `preset_id`
    INTEGER
    PRIMARY
    KEY
    AUTOINCREMENT
    NOT
    NULL,
    `user_id`
    INTEGER
    NOT
    NULL,
    `preset_name`
    TEXT,
    `filter_position`
    REAL
    NOT
    NULL,
    `spread_ribbon_position`
    REAL
    NOT
    NULL,
    `waveform_selection`
    REAL
    NOT
    NULL,
    `noiseamount`
    REAL
    NOT
    NULL,
    `created`
    INTEGER
    NOT
    NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_preset_preset_name` ON `preset` (`preset_name`);