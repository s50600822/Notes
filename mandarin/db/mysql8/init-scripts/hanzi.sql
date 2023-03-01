CREATE database hanzi CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


use hanzi;

-- The character - pinyin relationship are many to many - both of them are needed to identify a meaningful definition.
-- Traditional and Simplified also do not have 1 - 1 relationship
CREATE TABLE hanzi (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  character_text CHAR(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  pinyin VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  english_meaning VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO hanzi (character_text, pinyin, english_meaning)
VALUES
('一', 'yī', 'one'),
('二', 'èr', 'two'),
('三', 'sān', 'three'),
('四', 'sì', 'four'),
('五', 'wǔ', 'five'),
('六', 'liù', 'six'),
('七', 'qī', 'seven'),
('八', 'bā', 'eight'),
('九', 'jiǔ', 'nine'),
('十', 'shí', 'ten'),
('百', 'bǎi', 'hundred'),
('千', 'qiān', 'thousand'),
('万', 'wàn', 'ten thousand'),
('人', 'rén', 'person'),
('大', 'dà', 'big'),
('小', 'xiǎo', 'small'),
('口', 'kǒu', 'mouth'),
('日', 'rì', 'sun, day'),
('月', 'yuè', 'moon, month'),
('火', 'huǒ', 'fire'),
('水', 'shuǐ', 'water'),
('木', 'mù', 'wood'),
('金', 'jīn', 'metal, gold'),
('土', 'tǔ', 'earth, soil'),
('山', 'shān', 'mountain'),
('川', 'chuān', 'river'),
('田', 'tián', 'field'),
('雨', 'yǔ', 'rain'),
('天', 'tiān', 'heaven, sky'),
('风', 'fēng', 'wind'),
('雪', 'xuě', 'snow'),
('男', 'nán', 'man, male'),
('女', 'nǚ', 'woman, female'),
('子', 'zǐ', 'child, son'),
('父', 'fù', 'father'),
('母', 'mǔ', 'mother'),
('兄', 'xiōng', 'older brother'),
('弟', 'dì', 'younger brother'),
('姐', 'jiě', 'older sister'),
('妹', 'mèi', 'younger sister'),
('王', 'wáng', 'king, surname Wang'),
('李', 'lǐ', 'plum, surname Li'),
('张', 'zhāng', 'stretch, surname Zhang'),
('刘', 'liú', 'to kill, surname Liu'),
('陈', 'chén', 'exhibit, surname Chen'),
('杨', 'yáng', 'poplar, willow, surname Yang'),
('赵', 'zhào', 'shiny, surname Zhao'),
('黄', 'huáng', 'yellow, surname Huang'),
('周', 'zhōu', 'week, surname Zhou'),
('吴', 'wú', 'not have, surname Wu'),
('徐', 'xú', 'slowly, surname Xu'),
('孙', 'sūn', 'grandchild, surname Sun'),
('胡', 'hú', 'beard, surname Hu'),
('朱', 'zhū', 'vermilion, surname Zhu'),
('高', 'gāo', 'tall, surname Gao'),
('林', 'lín', 'forest, surname Lin');