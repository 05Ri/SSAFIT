DROP DATABASE IF EXISTS `ssafit_db`;

CREATE DATABASE `ssafit_db`;
USE `ssafit_db`;

DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
	`video_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `url` VARCHAR(500) NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `part` VARCHAR(40) NOT NULL,
    `view_cnt` INT DEFAULT 0
);

CREATE TABLE `user` (
	`user_id` VARCHAR(10) NOT NULL PRIMARY KEY,
    `password` VARCHAR(20) NOT NULL,
    `name` VARCHAR(10) NOT NULL
);

CREATE TABLE `review` (
	`review_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`video_id` INT NOT NULL,
	`user_id` VARCHAR(10) NOT NULL,
    `title` VARCHAR(40) NOT NULL,
    `content` VARCHAR(500) NOT NULL,
    `reg_date` DATETIME DEFAULT now(),
    
    FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`),
	FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);

INSERT INTO `video` (`video_id`, `title`, `url`, `part`, `view_cnt`)
VALUES
(0, "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "https://www.youtube.com/embed/gMaB-fG4u4g", "전신", 0),
(0, "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "https://www.youtube.com/embed/swRNeYw1JkY", "전신", 0),
(0, "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "https://www.youtube.com/embed/54tTYO-vU2E", "상체", 0),
(0, "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "https://www.youtube.com/embed/QqqZH3j_vH0", "상체", 0),
(0, "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "https://www.youtube.com/embed/tzN6ypk6Sps", "하체", 0),
(0, "저는 하체 식주의자 입니다", "https://www.youtube.com/embed/u5OgcZdNbMo", "하체", 0),
(0, "11자복근 복부 최고의 운동 [복근 핵매운맛]", "https://www.youtube.com/embed/PjGcOP-TQPE", "복부", 0),
(0, "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "https://www.youtube.com/embed/7TLk7pscICk", "전신", 0);

SELECT *
FROM `video`
ORDER BY `view_cnt` DESC;