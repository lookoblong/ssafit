DROP DATABASE IF EXISTS ssafit;
CREATE DATABASE ssafit;
USE ssafit;

CREATE TABLE user(
	user_seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id VARCHAR(20) UNIQUE NOT NULL,
	user_password VARCHAR(20),
    user_email VARCHAR(50) UNIQUE,
    user_nickname VARCHAR(20) UNIQUE,
    is_kakao SMALLINT DEFAULT 0
)ENGINE = InnoDB;

CREATE TABLE user_detail(
	user_seq INT NOT NULL PRIMARY KEY ,
	user_profile_pic VARCHAR(2000),
	# user detail
	user_gender TINYINT, # 0 : 남
	user_age INT,
	user_height NUMERIC,
	user_weight NUMERIC,
	user_job VARCHAR(20),
	user_level SMALLINT, #운동 숙련도 0 ~ 10 까지 선택
	user_preferred_place VARCHAR(10),
	user_extra VARCHAR(20),
	FOREIGN KEY (user_seq) REFERENCES user (user_seq)
)ENGINE = InnoDB;

CREATE TABLE user_schedule(
	user_seq INT NOT NULL PRIMARY KEY,
	user_schedule TEXT NOT NULL,
	CONSTRAINT fk_user_seq_schedule
		FOREIGN KEY (user_seq) 
		REFERENCES User (user_seq)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE video (
	video_id INT NOT NULL AUTO_INCREMENT unique PRIMARY KEY,
	video_title VARCHAR(100) NOT NULL,
	video_url VARCHAR(100) NOT NULL,
	video_part VARCHAR(20) NOT NULL,
    video_created_at DATETIME DEFAULT NOW(),
    video_view_cnt INT DEFAULT 0
)ENGINE = InnoDB;

CREATE TABLE review (
	review_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	video_id INT NOT NULL,
	user_id VARCHAR(20) NOT NULL,
	review_created_at DATETIME DEFAULT NOW(),
	review_title VARCHAR(100),
	review_content VARCHAR(255)
) ENGINE = InnoDB;

CREATE TABLE board(
	board_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	board_title VARCHAR(200) NOT NULL,
	board_user_id VARCHAR(20) NOT NULL, #user Id -> 데이터 인서트 할때 외부 테이블 (user)에서 가져와야함
	board_content VARCHAR(1000) NOT NULL,
	board_file VARCHAR(100),
    CONSTRAINT fk_user_seq_board
	FOREIGN KEY (board_user_id) 
    REFERENCES user (user_id)
    ON DELETE NO ACTION
	ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE followings (
	user_id VARCHAR(20) NOT NULL UNIQUE,
	following_id VARCHAR(20) NOT NULL UNIQUE,
	PRIMARY KEY (user_id, following_id)
	
)ENGINE = InnoDB;

CREATE TABLE bookmarks (
	user_id VARCHAR(20) NOT NULL,
	video_id INT NOT NULL,
	PRIMARY KEY(user_id, video_id),
    CONSTRAINT fk_user_id_bookmarks
	FOREIGN KEY (user_id) 
    REFERENCES user(user_id),
    CONSTRAINT fk_video_id_bookmarks
	FOREIGN KEY (video_id) 
    REFERENCES video(video_id)
    
)ENGINE = InnoDB;



-- user
insert into user (user_id, user_password) values ("admin", "q1w2e3r4");
insert into user (user_id, user_password) values ("ssafy", "ssafy");
insert into user (user_id, user_password) values ("samsung", "joosik");
insert into user (user_id, user_password) values ("baek", "ju");
insert into user (user_id, user_password) values ("jwo", "yong");
select * from user;

-- followings
insert into followings values ("admin", "ssafy");
insert into followings values ("ssafy", "admin"); -- 맞팔
insert into followings values ("samsung", "baek");
-- delete from followings where (user_id, following_id) =("admin", "ssafy");
-- select * from followings;
select following_id followId from followings where user_id= "admin";

-- user_detail
insert into user_detail values (1, null, 0, 28, 178, 78, "student", 5, "home", "시간이 없어용");

-- video
insert into video (video_title, video_url, video_part) values ("집에서 칼로리 불태우는 최고의 유산소운동 [칼소폭 매운맛]", "https://www.youtube.com/watch?v=lKwZ2DU4P-A", "유산소"); 
insert into video (video_title, video_url, video_part) values ("뱃살 아랫뱃살 최고의 운동", "https://www.youtube.com/watch?v=0L5gAT1fJaM", "복부"); 
insert into video (video_title, video_url, video_part) values ("허벅지살 다리살 최고의 운동", "https://www.youtube.com/watch?v=LK9e6mg4cmQ", "다리"); 


-- review (video에 다는 리뷰)
insert into review (video_id, user_id, review_title, review_content) values (1, "admin", "재미없네", "노잼");
insert into review (video_id, user_id, review_title, review_content) values (1, "ssafy", "어려워용", "나만그럼?");
insert into review (video_id, user_id, review_title, review_content) values (1, "samsung", "삭제해라", "애송이");
insert into review (video_id, user_id, review_title, review_content) values (1, "baek", "백천주", "운동마스터");

insert into review (video_id, user_id, review_title, review_content) values (2, "admin", "넘빡셈", "어케함;;");

-- board
insert into board (board_title, board_user_id, board_content, board_file) values ("공지사항", "admin", "떠들지 마시오", null);
insert into board (board_title, board_user_id, board_content, board_file) values ("운동 재밌음?", "ssafy", "나도 ㅎㅎ", null);
select * from board;

-- bookmarks
insert into bookmarks (user_id, video_id) values ("admin", 1);
insert into bookmarks (user_id, video_id) values ("admin", 2);
insert into bookmarks (user_id, video_id) values ("ssafy", 1);
-- delete from bookmarks where (user_id, video_id) = ("admin", 1);
select * from bookmarks;
select video_id videoId from bookmarks where user_id="admin";
