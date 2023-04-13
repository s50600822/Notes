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



-- CREATE TABLE pinyin (
--   pinyin VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci PRIMARY KEY
-- ) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


-- MIND THE COLLATE, IF DECLARE LIKE ABOVE, THE FOLLOWING INSERT WILL PRODUCE AND ERROR CAUSE yú AND yu CARE CONSIDERED THE SAME
-- INSERT INTO pinyin (pinyin)
-- VALUES
-- ('yú'),('yu')


CREATE TABLE pinyin (
  pinyin VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin PRIMARY KEY
) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

INSERT INTO pinyin (pinyin)
VALUES
('yì'),('xī'),('bì'),('lì'),('yù'),('zhì'),('jì'),('fú'),('yú'),('jī'),('qí'),('shì'),('jué'),('jí'),('líng'),('bó'),('lù'),('hé'),('huì'),('jiàn'),('yǎn'),('yí'),('jù'),('xiè'),('yuán'),('jiān'),('jié'),('jū'),('tóng'),('zī'),('chéng'),('è'),('fù'),('gǔ'),('lí'),('mò'),('wěi'),('xiāo'),('bèi'),('huáng'),('qiān'),('sù'),('yàn'),('hú'),('jiǎn'),('jiāo'),('jìn'),('qū'),('shàn'),('wù'),('zhī'),('zhuó'),('dì'),('lín'),('wéi'),('wèi'),('zhù'),('dài'),('shēn'),('shū'),('yīn'),('yóu'),('yǔ'),('yuè'),('zhēn'),('huán'),('jiā'),('jīng'),('jìng'),('kē'),('qiú'),('sī'),('xù'),('xún'),('yán'),('yáo'),('yǐ'),('chán'),('dàn'),('diàn'),('hóng'),('hù'),('jiǎo'),('jiào'),('liáo'),('liú'),('méi'),('qì'),('quán'),('shān'),('sì'),('wǔ'),('xū'),('yíng'),('dié'),('gū'),('hàn'),('niè'),('pí'),('qī'),('shī'),('tán'),('xiàn'),('yān'),('yī'),('yín'),('yīng'),('zhǐ'),('biāo'),('fǔ'),('liè'),('lóng'),('píng'),('shí'),('shù'),('xiān'),('xié'),('xīn'),('xuān'),('yáng'),('bā'),('dá'),('dí'),('fēng'),('gān'),('gé'),('hán'),('huàn'),('jiè'),('lán'),('mù'),('péng'),('qú'),('róng'),('suì'),('táng'),('tuó'),('wú'),('xiá'),('xiǎn'),('yè'),('yōng'),('zhū'),('biàn'),('chī'),('fán'),('gōng'),('guàn'),('huò'),('jùn'),('kuí'),('lǐ'),('lián'),('lú'),('mào'),('méng'),('miǎn'),('mó'),('ní'),('pú'),('qín'),('wǎn'),('xián'),('xiāng'),('zhòu'),('áo'),('bō'),('chá'),('chóu'),('chù'),('fū'),('gāng'),('gē'),('guī'),('hè'),('huī'),('jiē'),('jiù'),('jǔ'),('lǚ'),('mí'),('pī'),('qián'),('qiàn'),('rèn'),('shè'),('xǐ'),('xì'),('xuàn'),('yǒng'),('yòu'),('yún'),('yùn'),('zhēng'),('zǐ'),('ài'),('ào'),('bǐ'),('bīn'),('bù'),('chì'),('chōng'),('cí'),('gòu'),('gù'),('jǐ'),('jiàng'),('jīn'),('jǐng'),('kè'),('kūn'),('liáng'),('lóu'),('luò'),('mì'),('qǐ'),('qiāng'),('qiáo'),('rú'),('shā'),('suō'),('tí'),('tì'),('wēi'),('xíng'),('xùn'),('yá'),('zé'),('zhā'),('zhà'),('zhān'),('zhào'),('zhí'),('zuò'),('chǎn'),('chén'),('chí'),('dān'),('dòng'),('é'),('fēi'),('fěi'),('hào'),('hū'),('jiāng'),('jǐn'),('jūn'),('luó'),('màn'),('máng'),('mǐn'),('míng'),('pì'),('qiè'),('qiū'),('què'),('táo'),('tíng'),('tú'),('xí'),('xiū'),('xiù'),('zhāng'),('zhàng'),('zhé'),('zhōu'),('ān'),('bān'),('bàn'),('bàng'),('bāo'),('bào'),('bǐng'),('chà'),('cháng'),('chú'),('dàng'),('dī'),('dǐ'),('dīng'),('fèi'),('fèn'),('guǐ'),('guì'),('hòu'),('kǎi'),('kuài'),('láng'),('léi'),('liàn'),('máo'),('pǔ'),('shào'),('sōu'),('tā'),('tāo'),('wén'),('wò'),('wū'),('xiào'),('yà'),('yǒu'),('zào'),('zhěn'),('zhèn'),('zhōng'),('zhuàn'),('biān'),('chā'),('chēng'),('chǔ'),('cōng'),('cuì'),('dú'),('dù'),('duàn'),('fēn'),('gǎn'),('gōu'),('guān'),('guō'),('háo'),('héng'),('jiǎ'),('juàn'),('kuàng'),('kuì'),('là'),('lěi'),('liàng'),('luán'),('měng'),('nà'),('pǐ'),('qiāo'),('qīng'),('qióng'),('shèn'),('shǔ'),('shuò'),('tà'),('tái'),('tián'),('tǐng'),('xuán'),('yā'),('yāo'),('yào'),('zhú'),('zōng'),('bà'),('chāo'),('chuí'),('cù'),('dào'),('diāo'),('dìng'),('dūn'),('dùn'),('duò'),('fāng'),('gài'),('gāo'),('gěng'),('guāng'),('hóu'),('huà'),('jiá'),('jiǒng'),('jiū'),('juān'),('lái'),('làng'),('láo'),('lào'),('liào'),('liù'),('lǔ'),('lǜ'),('lún'),('mán'),('mǐ'),('miǎo'),('nì'),('níng'),('pán'),('páng'),('páo'),('qiào'),('ruò'),('sè'),('shāo'),('shēng'),('shòu'),('shuāng'),('sōng'),('téng'),('tī'),('tiáo'),('tún'),('wā'),('wō'),('xiàng'),('xīng'),('xìng'),('xǔ'),('xūn'),('yìn'),('yōu'),('yuān'),('yuàn'),('zēng'),('zhá'),('zhàn'),('zhèng'),('zhǔ'),('àn'),('bǎo'),('bēi'),('bèng'),('bǔ'),('cáo'),('chāng'),('chǎng'),('chēn'),('chèn'),('chǐ'),('chún'),('cuò'),('dā'),('dèng'),('diào'),('dōng'),('duō'),('ěr'),('fàn'),('fén'),('gǎo'),('gēng'),('huá'),('huō'),('jiǔ'),('kān'),('kàn'),('kū'),('lǎn'),('lè'),('mài'),('mín'),('móu'),('mǔ'),('nài'),('náo'),('nóng'),('ōu'),('pá'),('pàn'),('pèi'),('pō'),('qíng'),('qìng'),('ruì'),('shà'),('shěn'),('shǐ'),('suǒ'),('tài'),('tǎn'),('tāng'),('tǎng'),('wān'),('wán'),('wǎng'),('xiōng'),('yāng'),('yàng'),('yǐn'),('zhǎn'),('zhāo'),('zhuō'),('āi'),('ǎi'),('bá'),('bǎi'),('bǎn'),('cāng'),('cè'),('chān'),('chè'),('chū'),('chūn'),('cì'),('dǎn'),('dāo'),('dǎo'),('dòu'),('duì'),('duǒ'),('ér'),('fá'),('fáng'),('gā'),('gāi'),('gàn'),('gào'),('gě'),('gǒu'),('guā'),('guǎn'),('gǔn'),('guó'),('guǒ'),('hān'),('háng'),('hōng'),('hūn'),('jià'),('jiǎng'),('jú'),('kàng'),('lài'),('lǎo'),('lèi'),('lìn'),('mǎ'),('měi'),('mèi'),('nán'),('niǔ'),('nuò'),('ǒu'),('piān'),('pián'),('pín'),('pò'),('qiáng'),('qīn'),('qǔ'),('ráng'),('róu'),('rù'),('shāng'),('sháo'),('shú'),('suī'),('tiǎn'),('tīng'),('wēn'),('xiǎng'),('xué'),('yū'),('yūn'),('zǎo'),('zhè'),('zhòng'),('zōu'),('zǔ'),('zūn'),('ā'),('bāng'),('bēn'),('biǎn'),('bìn'),('chàn'),('chàng'),('cháo'),('chóng'),('chuò'),('cī'),('cóng'),('cuī'),('cuō'),('dāng'),('dēng'),('diān'),('dǒu'),('dū'),('dǔ'),('fān'),('fǎng'),('fèng'),('gàng'),('gè'),('gǒng'),('guà'),('hài'),('huái'),('huí'),('huǒ'),('kǎn'),('kāng'),('kǎo'),('kě'),('kòu'),('kù'),('kuāng'),('kuī'),('kuò'),('lǎng'),('liǎn'),('liǎo'),('liǔ'),('lǒng'),('lòu'),('lüè'),('luǒ'),('mǎo'),('mén'),('nǎi'),('nìng'),('pái'),('péi'),('pēng'),('piāo'),('piào'),('pū'),('qiǎn'),('sāo'),('shē'),('shé'),('shèng'),('sǒng'),('sòng'),('sǒu'),('sū'),('tān'),('tǒng'),('tū'),('tuō'),('tuò'),('wēng'),('xià'),('xiáng'),('xiǎo'),('xiē'),('yǎo'),('yē'),('yǐng'),('zā'),('zǎn'),('zàn'),('zhǎ'),('zhài'),('zhě'),('zhuàng'),('zhuī'),('zhuì'),('zì'),('zú'),('zuì'),('ǎn'),('bèn'),('bēng'),('biǎo'),('bīng'),('bò'),('cái'),('cǎi'),('chǎ'),('chěng'),('chǒu'),('chuán'),('cǐ'),('cuān'),('cuó'),('dǎng'),('diǎn'),('dōu'),('duó'),('féng'),('gá'),('hǎn'),('hē'),('hǔ'),('huǎng'),('hún'),('kǎ'),('kào'),('kěn'),('kēng'),('kōng'),('kōu'),('kuǐ'),('kǔn'),('lā'),('léng'),('liǎng'),('lǐn'),('lǘ'),('mà'),('mèn'),('miáo'),('nǎo'),('nǐ'),('nián'),('niǎn'),('nú'),('nǔ'),('nuó'),('pā'),('pài'),('pāng'),('pēi'),('piáo'),('pīng'),('pó'),('pù'),('qiǎng'),('qiàng'),('qiǎo'),('qǐng'),('qù'),('quān'),('rán'),('rǎn'),('ráo'),('rén'),('ruǎn'),('sǎ'),('sà'),('sāi'),('sǎn'),('sǎng'),('sào'),('shǎng'),('shǒu'),('shuì'),('suí'),('sūn'),('sǔn'),('tǎ'),('tàn'),('tè'),('tiǎo'),('tòng'),('tù'),('tuì'),('wàn'),('wàng'),('wěn'),('xìn'),('xuǎn'),('yǎng'),('yé'),('yìng'),('yǔn'),('zāi'),('zǎi'),('zāng'),('zàng'),('zèng'),('zhǎng'),('zhǒng'),('zhuān'),('zhuāng'),('zhūn'),('zuó'),('ái'),('bǎ'),('bài'),('bǎng'),('běn'),('biào'),('biē'),('bié'),('bìng'),('cài'),('cān'),('cán'),('cǎn'),('càn'),('céng'),('chāi'),('chái'),('chōu'),('chuài'),('chuān'),('chuāng'),('chuáng'),('chuō'),('còu'),('cuàn'),('cūn'),('da'),('dāi'),('dǎi'),('dé'),('de'),('dǐng'),('ē'),('èr'),('féi'),('gèn'),('gòng'),('hāi'),('hái'),('hǎi'),('hāo'),('hēi'),('hěn'),('huā'),('huāng'),('huàng'),('huǐ'),('hùn'),('huó'),('jiě'),('jiōng'),('kā'),('kāi'),('ké'),('kǒng'),('kòng'),('kuà'),('kuáng'),('lá'),('lǐng'),('lìng'),('lǒu'),('mā'),('má'),('mǎng'),('mián'),('miào'),('miè'),('nǎn'),('nǎng'),('nào'),('niàn'),('niǎo'),('pān'),('pāo'),('pào'),('piǎo'),('piē'),('piě'),('pǒ'),('póu'),('qiā'),('qià'),('qìn'),('quǎn'),('quē'),('qún'),('rǎng'),('rěn'),('rǔ'),('sā'),('sān'),('shǎn'),('shàng'),('shén'),('shuài'),('shuān'),('shùn'),('tāi'),('tiān'),('tiāo'),('tiào'),('tiē'),('tóu'),('tǔ'),('tuān'),('tuí'),('tūn'),('tuǒ'),('wà'),('wāng'),('wèn'),('xiā'),('xiáo'),('xǐng'),('xiǔ'),('xuē'),('yě'),('yòng'),('yuē'),('zài'),('zhái'),('zhǎo'),('zhē'),('zhóu'),('zòng'),('zǔn'),('zuǒ'),('áng'),('āo'),('ǎo'),('ba'),('bái'),('báo'),('bei'),('běng'),('bī'),('bí'),('bǒ'),('bo'),('bū'),('cā'),('cāi'),('cāo'),('cén'),('chài'),('chǎo'),('chē'),('chě'),('chèng'),('chòng'),('chuāi'),('chuǎn'),('chuàn'),('chuàng'),('chuī'),('cú'),('cuǐ'),('dáo'),('děng'),('diē'),('diū'),('dǒng'),('duān'),('dǔn'),('ēn'),('fǎ'),('fà'),('fǎn'),('fěng'),('fǒu'),('gǎ'),('gǎng'),('gēn'),('gèng'),('guǎ'),('guāi'),('guài'),('guǎng'),('guàng'),('hā'),('hàng'),('hǎo'),('hēng'),('hèng'),('hǒng'),('hòng'),('huān'),('huǎn'),('jiáo'),('juǎn'),('juē'),('kài'),('kuā'),('kuǎ'),('kuǎi'),('kuān'),('la'),('làn'),('le'),('lèng'),('liāo'),('liū'),('lòng'),('lōu'),('lū'),('luō'),('ḿ'),('ma'),('mái'),('mǎi'),('mān'),('mǎn'),('mèng'),('mī'),('miàn'),('miē'),('miù'),('mú'),('nā'),('ná'),('nǎ'),('nàn'),('nāng'),('náng'),('nèn'),('niān'),('niào'),('nù'),('nǚ'),('nǜ'),('nüè'),('òu'),('pà'),('pǎi'),('pén'),('pèng'),('piǎn'),('piàn'),('pīn'),('pìn'),('qié'),('qǐn'),('quàn'),('qūn'),('ràng'),('rì'),('rùn'),('sài'),('sāng'),('sǎo'),('shěng'),('shi'),('shuā'),('shuāi'),('shuàn'),('shǔn'),('sòu'),('suān'),('suàn'),('tàng'),('tiàn'),('tiě'),('tiè'),('tōng'),('tuán'),('tuī'),('wǎ'),('wáng'),('wèng'),('xiě'),('xióng'),('xiòng'),('xuě'),('xuè'),('yǎ'),('yō'),('yóng'),('zá'),('zān'),('zāo'),('zè'),('zéi'),('zhāi'),('zhěng'),('zhǒu'),('zhuā'),('zhǔn'),('zǒng'),('zòu'),('zū'),('zuān'),('zuǎn'),('zuàn'),('zuǐ'),('zuō'),('á'),('ǎ'),('à'),('a'),('āng'),('àng'),('bāi'),('běi'),('béng'),('biě'),('biè'),('bú'),('cáng'),('cǎo'),('cēn'),('cēng'),('cèng'),('chǎi'),('chào'),('chěn'),('chǒng'),('chòu'),('chuǎi'),('chuǎng'),('chǔn'),('cū'),('cuán'),('cún'),('cǔn'),('cùn'),('cuǒ'),('dǎ'),('dà'),('dē'),('dēi'),('děi'),('dèn'),('diǎ'),('duǎn'),('duī'),('ě'),('e'),('ê̄'),('ế'),('ê̌'),('ề'),('èn'),('fā'),('fàng'),('fěn'),('fó'),('gà'),('gǎi'),('gěi'),('gén'),('gěn'),('guǎi'),('gùn'),('guò'),('há'),('hǎ'),('hà'),('hāng'),('hén'),('hèn'),('hng'),('hōu'),('hǒu'),('huài'),('huo'),('jia'),('jie'),('juě'),('juè'),('káng'),('kāo'),('kēi'),('kèn'),('kǒu'),('kǔ'),('kuǎn'),('kuǎng'),('kùn'),('lǎ'),('lāng'),('lāo'),('lēi'),('lei'),('lēng'),('lěng'),('lī'),('li'),('liǎ'),('liē'),('liě'),('līn'),('lo'),('lou'),('lu'),('luǎn'),('luàn'),('lūn'),('lǔn'),('lùn'),('luo'),('m̀'),('māng'),('māo'),('me'),('mēn'),('men'),('mēng'),('miāo'),('mǐng'),('mìng'),('mō'),('mǒ'),('mōu'),('mǒu'),('na'),('nān'),('nàng'),('nāo'),('né'),('nè'),('ne'),('něi'),('nèi'),('néng'),('ńg'),('ňg'),('ǹg'),('nī'),('niáng'),('niàng'),('niē'),('nín'),('nǐng'),('niū'),('niú'),('niù'),('nòng'),('nòu'),('nuǎn'),('ō'),('ó'),('ò'),('pāi'),('pǎng'),('pàng'),('pǎo'),('pēn'),('pèn'),('pěng'),('pǐn'),('po'),('pōu'),('pǒu'),('qiá'),('qiǎ'),('qiē'),('qiě'),('qiǔ'),('qu'),('qué'),('rāng'),('rǎo'),('rào'),('rě'),('rè'),('rēng'),('réng'),('rǒng'),('ròu'),('ruán'),('ruí'),('ruǐ'),('sàn'),('sàng'),('sēn'),('sēng'),('shá'),('shǎ'),('shāi'),('shǎi'),('shài'),('shang'),('shǎo'),('shě'),('shéi'),('shéng'),('shōu'),('shóu'),('shuǎ'),('shuà'),('shuǎi'),('shuǎng'),('shuí'),('shuǐ'),('shuō'),('sǐ'),('sú'),('suǐ'),('tǎo'),('tào'),('tēng'),('tǐ'),('tìng'),('tōu'),('tòu'),('tuǎn'),('tuàn'),('tuǐ'),('tùn'),('wá'),('wa'),('wāi'),('wǎi'),('wài'),('wěng'),('wǒ'),('xǐn'),('xú'),('xu'),('ya'),('yo'),('yuǎn'),('yuě'),('zǎ'),('zán'),('zǎng'),('záo'),('zěn'),('zèn'),('zha'),('zhǎi'),('zháo'),('zhe'),('zhuǎ'),('zhuài'),('zhuǎn'),('zhuǎng'),('zǒu'),('yi'),('ji'),('yu'),('xi'),('fu'),('zhi'),('qi'),('yan'),('wei'),('jian'),('bi'),('ju'),('wu'),('xian'),('jiao'),('qian'),('di'),('hu'),('zhu'),('gu'),('shu'),('yin'),('you'),('jing'),('pi'),('xie'),('hui'),('chi'),('jin'),('ying'),('zi'),('yuan'),('he'),('xiao'),('xuan'),('yao'),('chan'),('han'),('shan'),('zhen'),('shen'),('xun'),('cheng'),('huan'),('mo'),('si'),('chu'),('ling'),('ge'),('jue'),('ke'),('yun'),('tong'),('dan'),('fei'),('gui'),('tan'),('huang'),('kui'),('mi'),('ti'),('wan'),('xiang'),('yang'),('yong'),('lin'),('pu'),('qiu'),('liao'),('liu'),('mao'),('mei'),('qiao'),('tang'),('xing'),('bao'),('cha'),('lian'),('su'),('zhou'),('zhuo'),('ao'),('bian'),('chang'),('fan'),('gan'),('jiu'),('tuo'),('dian'),('du'),('guan'),('jiang'),('qing'),('quan'),('ban'),('chen'),('ci'),('fen'),('hong'),('ni'),('ting'),('zhan'),('feng'),('gou'),('lü'),('qin'),('sui'),('ye'),('zhang'),('ai'),('dai'),('duo'),('jun'),('lan'),('meng'),('mu'),('xiu'),('yue'),('biao'),('hao'),('lang'),('liang'),('peng'),('she'),('tao'),('wen'),('xia'),('bu'),('lao'),('long'),('qiang'),('shao'),('ta'),('tu'),('zhao'),('an'),('chou'),('gong'),('guo'),('man'),('ru'),('dao'),('dong'),('gao'),('ping'),('tian'),('xin'),('zheng'),('zuo'),('chong'),('die'),('ding'),('fang'),('hou'),('mian'),('ren'),('sha'),('suo'),('wo'),('zao'),('bang'),('dun'),('gang'),('kan'),('kuang'),('min'),('nie'),('pan'),('song'),('zhong'),('bin'),('cuo'),('dang'),('juan'),('kun'),('lie'),('tai'),('tiao'),('bing'),('cui'),('er'),('geng'),('miao'),('pei'),('rong'),('sheng'),('sou'),('wang'),('chao'),('diao'),('gai'),('hua'),('kai'),('mang'),('nao'),('ou'),('pian'),('piao'),('chun'),('cong'),('deng'),('dou'),('hai'),('lai'),('qie'),('que'),('shou'),('ze'),('zhuan'),('zong'),('gua'),('hun'),('ku'),('ming'),('nian'),('pa'),('pang'),('xue'),('zan'),('zu'),('beng'),('cai'),('can'),('duan'),('heng'),('kang'),('kuai'),('nai'),('pao'),('tun'),('zeng'),('bai'),('ben'),('chuan'),('cu'),('ga'),('guang'),('jiong'),('luan'),('mai'),('nan'),('ning'),('pai'),('pin'),('xiong'),('zhai'),('cao'),('che'),('chui'),('fa'),('kao'),('kou'),('lun'),('nu'),('nuo'),('rang'),('sa'),('shuo'),('tui'),('zai'),('zhuang'),('zhui'),('chai'),('hang'),('kong'),('mou'),('niu'),('qiong'),('rui'),('sao'),('shuang'),('teng'),('zou'),('zun'),('chuang'),('chuo'),('cuan'),('nong'),('qia'),('ran'),('ruo'),('se'),('sun'),('weng'),('za'),('zang'),('cang'),('dui'),('gun'),('kua'),('leng'),('rou'),('san'),('tuan'),('zui'),('bie'),('ce'),('cun'),('gen'),('huai'),('ka'),('nang'),('rao'),('sang'),('shuai'),('shui'),('zhun'),('ceng'),('guai'),('hen'),('ken'),('kuo'),('lüe'),('mie'),('niao'),('pie'),('qun'),('ruan'),('sai'),('shuan'),('shun'),('tie'),('tou'),('zuan'),('ang'),('chuai'),('keng'),('nü'),('pou'),('suan'),('te'),('cen'),('cou'),('en'),('ha'),('hei'),('kuan'),('pen'),('shai'),('shua'),('wai'),('zhua'),('ca'),('dei'),('diu'),('fou'),('m'),('miu'),('nei'),('nen'),('niang'),('nüe'),('o'),('re'),('reng'),('ri'),('run'),('zei'),('zen'),('den'),('dia'),('ê'),('fo'),('gei'),('kei'),('lia'),('neng'),('ng'),('nin'),('nou'),('nuan'),('sen'),('seng'),('shei'),('zhuai')




-- INSERT INTO pinyin (pinyin)
-- VALUES
-- ('yì'),
-- ('xī'),
-- ('bì'),
-- ('lì'),
-- ('yù'),
-- ('zhì'),
-- ('jì'),
-- ('fú'),
-- ('yú'),
-- ('jī'),
-- ('qí'),
-- ('shì'),
-- ('jué'),
-- ('jí'),
-- ('líng'),
-- ('bó'),
-- ('lù'),
-- ('hé'),
-- ('huì'),
-- ('jiàn'),
-- ('yǎn'),
-- ('yí'),
-- ('jù'),
-- ('xiè'),
-- ('yuán'),
-- ('jiān'),
-- ('jié'),
-- ('jū'),
-- ('tóng'),
-- ('zī'),
-- ('chéng'),
-- ('è'),
-- ('fù'),
-- ('gǔ'),
-- ('lí'),
-- ('mò'),
-- ('wěi'),
-- ('xiāo'),
-- ('bèi'),
-- ('huáng'),
-- ('qiān'),
-- ('sù'),
-- ('yàn'),
-- ('hú'),
-- ('jiǎn'),
-- ('jiāo'),
-- ('jìn'),
-- ('qū'),
-- ('shàn'),
-- ('wù'),
-- ('zhī'),
-- ('zhuó'),
-- ('dì'),
-- ('lín'),
-- ('wéi'),
-- ('wèi'),
-- ('zhù'),
-- ('dài'),
-- ('shēn'),
-- ('shū'),
-- ('yīn'),
-- ('yóu'),
-- ('yǔ'),
-- ('yuè'),
-- ('zhēn'),
-- ('huán'),
-- ('jiā'),
-- ('jīng'),
-- ('jìng'),
-- ('kē'),
-- ('qiú'),
-- ('sī'),
-- ('xù'),
-- ('xún'),
-- ('yán'),
-- ('yáo'),
-- ('yǐ'),
-- ('chán'),
-- ('dàn'),
-- ('diàn'),
-- ('hóng'),
-- ('hù'),
-- ('jiǎo'),
-- ('jiào'),
-- ('liáo'),
-- ('liú'),
-- ('méi'),
-- ('qì'),
-- ('quán'),
-- ('shān'),
-- ('sì'),
-- ('wǔ'),
-- ('xū'),
-- ('yíng'),
-- ('dié'),
-- ('gū'),
-- ('hàn'),
-- ('niè'),
-- ('pí'),
-- ('qī'),
-- ('shī'),
-- ('tán'),
-- ('xiàn'),
-- ('yān'),
-- ('yī'),
-- ('yín'),
-- ('yīng'),
-- ('zhǐ'),
-- ('biāo'),
-- ('fǔ'),
-- ('liè'),
-- ('lóng'),
-- ('píng'),
-- ('shí'),
-- ('shù'),
-- ('xiān'),
-- ('xié'),
-- ('xīn'),
-- ('xuān'),
-- ('yáng'),
-- ('bā'),
-- ('dá'),
-- ('dí'),
-- ('fēng'),
-- ('gān'),
-- ('gé'),
-- ('hán'),
-- ('huàn'),
-- ('jiè'),
-- ('lán'),
-- ('mù'),
-- ('péng'),
-- ('qú'),
-- ('róng'),
-- ('suì'),
-- ('táng'),
-- ('tuó'),
-- ('wú'),
-- ('xiá'),
-- ('xiǎn'),
-- ('yè'),
-- ('yōng'),
-- ('zhū'),
-- ('biàn'),
-- ('chī'),
-- ('fán'),
-- ('gōng'),
-- ('guàn'),
-- ('huò'),
-- ('jùn'),
-- ('kuí'),
-- ('lǐ'),
-- ('lián'),
-- ('lú'),
-- ('mào'),
-- ('méng'),
-- ('miǎn'),
-- ('mó'),
-- ('ní'),
-- ('pú'),
-- ('qín'),
-- ('wǎn'),
-- ('xián'),
-- ('xiāng'),
-- ('zhòu'),
-- ('áo'),
-- ('bō'),
-- ('chá'),
-- ('chóu'),
-- ('chù'),
-- ('fū'),
-- ('gāng'),
-- ('gē'),
-- ('guī'),
-- ('hè'),
-- ('huī'),
-- ('jiē'),
-- ('jiù'),
-- ('jǔ'),
-- ('lǚ'),
-- ('mí'),
-- ('pī'),
-- ('qián'),
-- ('qiàn'),
-- ('rèn'),
-- ('shè'),
-- ('xǐ'),
-- ('xì'),
-- ('xuàn'),
-- ('yǒng'),
-- ('yòu'),
-- ('yún'),
-- ('yùn'),
-- ('zhēng'),
-- ('zǐ'),
-- ('ài'),
-- ('ào'),
-- ('bǐ'),
-- ('bīn'),
-- ('bù'),
-- ('chì'),
-- ('chōng'),
-- ('cí'),
-- ('gòu'),
-- ('gù'),
-- ('jǐ'),
-- ('jiàng'),
-- ('jīn'),
-- ('jǐng'),
-- ('kè'),
-- ('kūn'),
-- ('liáng'),
-- ('lóu'),
-- ('luò'),
-- ('mì'),
-- ('qǐ'),
-- ('qiāng'),
-- ('qiáo'),
-- ('rú'),
-- ('shā'),
-- ('suō'),
-- ('tí'),
-- ('tì'),
-- ('wēi'),
-- ('xíng'),
-- ('xùn'),
-- ('yá'),
-- ('zé'),
-- ('zhā'),
-- ('zhà'),
-- ('zhān'),
-- ('zhào'),
-- ('zhí'),
-- ('zuò'),
-- ('chǎn'),
-- ('chén'),
-- ('chí'),
-- ('dān'),
-- ('dòng'),
-- ('é'),
-- ('fēi'),
-- ('fěi'),
-- ('hào'),
-- ('hū'),
-- ('jiāng'),
-- ('jǐn'),
-- ('jūn'),
-- ('luó'),
-- ('màn'),
-- ('máng'),
-- ('mǐn'),
-- ('míng'),
-- ('pì'),
-- ('qiè'),
-- ('qiū'),
-- ('què'),
-- ('táo'),
-- ('tíng'),
-- ('tú'),
-- ('xí'),
-- ('xiū'),
-- ('xiù'),
-- ('zhāng'),
-- ('zhàng'),
-- ('zhé'),
-- ('zhōu'),
-- ('ān'),
-- ('bān'),
-- ('bàn'),
-- ('bàng'),
-- ('bāo'),
-- ('bào'),
-- ('bǐng'),
-- ('chà'),
-- ('cháng'),
-- ('chú'),
-- ('dàng'),
-- ('dī'),
-- ('dǐ'),
-- ('dīng'),
-- ('fèi'),
-- ('fèn'),
-- ('guǐ'),
-- ('guì'),
-- ('hòu'),
-- ('kǎi'),
-- ('kuài'),
-- ('láng'),
-- ('léi'),
-- ('liàn'),
-- ('máo'),
-- ('pǔ'),
-- ('shào'),
-- ('sōu'),
-- ('tā'),
-- ('tāo'),
-- ('wén'),
-- ('wò'),
-- ('wū'),
-- ('xiào'),
-- ('yà'),
-- ('yǒu'),
-- ('zào'),
-- ('zhěn'),
-- ('zhèn'),
-- ('zhōng'),
-- ('zhuàn'),
-- ('biān'),
-- ('chā'),
-- ('chēng'),
-- ('chǔ'),
-- ('cōng'),
-- ('cuì'),
-- ('dú'),
-- ('dù'),
-- ('duàn'),
-- ('fēn'),
-- ('gǎn'),
-- ('gōu'),
-- ('guān'),
-- ('guō'),
-- ('háo'),
-- ('héng'),
-- ('jiǎ'),
-- ('juàn'),
-- ('kuàng'),
-- ('kuì'),
-- ('là'),
-- ('lěi'),
-- ('liàng'),
-- ('luán'),
-- ('měng'),
-- ('nà'),
-- ('pǐ'),
-- ('qiāo'),
-- ('qīng'),
-- ('qióng'),
-- ('shèn'),
-- ('shǔ'),
-- ('shuò'),
-- ('tà'),
-- ('tái'),
-- ('tián'),
-- ('tǐng'),
-- ('xuán'),
-- ('yā'),
-- ('yāo'),
-- ('yào'),
-- ('zhú'),
-- ('zōng'),
-- ('bà'),
-- ('chāo'),
-- ('chuí'),
-- ('cù'),
-- ('dào'),
-- ('diāo'),
-- ('dìng'),
-- ('dūn'),
-- ('dùn'),
-- ('duò'),
-- ('fāng'),
-- ('gài'),
-- ('gāo'),
-- ('gěng'),
-- ('guāng'),
-- ('hóu'),
-- ('huà'),
-- ('jiá'),
-- ('jiǒng'),
-- ('jiū'),
-- ('juān'),
-- ('lái'),
-- ('làng'),
-- ('láo'),
-- ('lào'),
-- ('liào'),
-- ('liù'),
-- ('lǔ'),
-- ('lǜ'),
-- ('lún'),
-- ('mán'),
-- ('mǐ'),
-- ('miǎo'),
-- ('nì'),
-- ('níng'),
-- ('pán'),
-- ('páng'),
-- ('páo'),
-- ('qiào'),
-- ('ruò'),
-- ('sè'),
-- ('shāo'),
-- ('shēng'),
-- ('shòu'),
-- ('shuāng'),
-- ('sōng'),
-- ('téng'),
-- ('tī'),
-- ('tiáo'),
-- ('tún'),
-- ('wā'),
-- ('wō'),
-- ('xiàng'),
-- ('xīng'),
-- ('xìng'),
-- ('xǔ'),
-- ('xūn'),
-- ('yìn'),
-- ('yōu'),
-- ('yuān'),
-- ('yuàn'),
-- ('zēng'),
-- ('zhá'),
-- ('zhàn'),
-- ('zhèng'),
-- ('zhǔ'),
-- ('àn'),
-- ('bǎo'),
-- ('bēi'),
-- ('bèng'),
-- ('bǔ'),
-- ('cáo'),
-- ('chāng'),
-- ('chǎng'),
-- ('chēn'),
-- ('chèn'),
-- ('chǐ'),
-- ('chún'),
-- ('cuò'),
-- ('dā'),
-- ('dèng'),
-- ('diào'),
-- ('dōng'),
-- ('duō'),
-- ('ěr'),
-- ('fàn'),
-- ('fén'),
-- ('gǎo'),
-- ('gēng'),
-- ('huá'),
-- ('huō'),
-- ('jiǔ'),
-- ('kān'),
-- ('kàn'),
-- ('kū'),
-- ('lǎn'),
-- ('lè'),
-- ('mài'),
-- ('mín'),
-- ('móu'),
-- ('mǔ'),
-- ('nài'),
-- ('náo'),
-- ('nóng'),
-- ('ōu'),
-- ('pá'),
-- ('pàn'),
-- ('pèi'),
-- ('pō'),
-- ('qíng'),
-- ('qìng'),
-- ('ruì'),
-- ('shà'),
-- ('shěn'),
-- ('shǐ'),
-- ('suǒ'),
-- ('tài'),
-- ('tǎn'),
-- ('tāng'),
-- ('tǎng'),
-- ('wān'),
-- ('wán'),
-- ('wǎng'),
-- ('xiōng'),
-- ('yāng'),
-- ('yàng'),
-- ('yǐn'),
-- ('zhǎn'),
-- ('zhāo'),
-- ('zhuō'),
-- ('āi'),
-- ('ǎi'),
-- ('bá'),
-- ('bǎi'),
-- ('bǎn'),
-- ('cāng'),
-- ('cè'),
-- ('chān'),
-- ('chè'),
-- ('chū'),
-- ('chūn'),
-- ('cì'),
-- ('dǎn'),
-- ('dāo'),
-- ('dǎo'),
-- ('dòu'),
-- ('duì'),
-- ('duǒ'),
-- ('ér'),
-- ('fá'),
-- ('fáng'),
-- ('gā'),
-- ('gāi'),
-- ('gàn'),
-- ('gào'),
-- ('gě'),
-- ('gǒu'),
-- ('guā'),
-- ('guǎn'),
-- ('gǔn'),
-- ('guó'),
-- ('guǒ'),
-- ('hān'),
-- ('háng'),
-- ('hōng'),
-- ('hūn'),
-- ('jià'),
-- ('jiǎng'),
-- ('jú'),
-- ('kàng'),
-- ('lài'),
-- ('lǎo'),
-- ('lèi'),
-- ('lìn'),
-- ('mǎ'),
-- ('měi'),
-- ('mèi'),
-- ('nán'),
-- ('niǔ'),
-- ('nuò'),
-- ('ǒu'),
-- ('piān'),
-- ('pián'),
-- ('pín'),
-- ('pò'),
-- ('qiáng'),
-- ('qīn'),
-- ('qǔ'),
-- ('ráng'),
-- ('róu'),
-- ('rù'),
-- ('shāng'),
-- ('sháo'),
-- ('shú'),
-- ('suī'),
-- ('tiǎn'),
-- ('tīng'),
-- ('wēn'),
-- ('xiǎng'),
-- ('xué'),
-- ('yū'),
-- ('yūn'),
-- ('zǎo'),
-- ('zhè'),
-- ('zhòng'),
-- ('zōu'),
-- ('zǔ'),
-- ('zūn'),
-- ('ā'),
-- ('bāng'),
-- ('bēn'),
-- ('biǎn'),
-- ('bìn'),
-- ('chàn'),
-- ('chàng'),
-- ('cháo'),
-- ('chóng'),
-- ('chuò'),
-- ('cī'),
-- ('cóng'),
-- ('cuī'),
-- ('cuō'),
-- ('dāng'),
-- ('dēng'),
-- ('diān'),
-- ('dǒu'),
-- ('dū'),
-- ('dǔ'),
-- ('fān'),
-- ('fǎng'),
-- ('fèng'),
-- ('gàng'),
-- ('gè'),
-- ('gǒng'),
-- ('guà'),
-- ('hài'),
-- ('huái'),
-- ('huí'),
-- ('huǒ'),
-- ('kǎn'),
-- ('kāng'),
-- ('kǎo'),
-- ('kě'),
-- ('kòu'),
-- ('kù'),
-- ('kuāng'),
-- ('kuī'),
-- ('kuò'),
-- ('lǎng'),
-- ('liǎn'),
-- ('liǎo'),
-- ('liǔ'),
-- ('lǒng'),
-- ('lòu'),
-- ('lüè'),
-- ('luǒ'),
-- ('mǎo'),
-- ('mén'),
-- ('nǎi'),
-- ('nìng'),
-- ('pái'),
-- ('péi'),
-- ('pēng'),
-- ('piāo'),
-- ('piào'),
-- ('pū'),
-- ('qiǎn'),
-- ('sāo'),
-- ('shē'),
-- ('shé'),
-- ('shèng'),
-- ('sǒng'),
-- ('sòng'),
-- ('sǒu'),
-- ('sū'),
-- ('tān'),
-- ('tǒng'),
-- ('tū'),
-- ('tuō'),
-- ('tuò'),
-- ('wēng'),
-- ('xià'),
-- ('xiáng'),
-- ('xiǎo'),
-- ('xiē'),
-- ('yǎo'),
-- ('yē'),
-- ('yǐng'),
-- ('zā'),
-- ('zǎn'),
-- ('zàn'),
-- ('zhǎ'),
-- ('zhài'),
-- ('zhě'),
-- ('zhuàng'),
-- ('zhuī'),
-- ('zhuì'),
-- ('zì'),
-- ('zú'),
-- ('zuì'),
-- ('ǎn'),
-- ('bèn'),
-- ('bēng'),
-- ('biǎo'),
-- ('bīng'),
-- ('bò'),
-- ('cái'),
-- ('cǎi'),
-- ('chǎ'),
-- ('chěng'),
-- ('chǒu'),
-- ('chuán'),
-- ('cǐ'),
-- ('cuān'),
-- ('cuó'),
-- ('dǎng'),
-- ('diǎn'),
-- ('dōu'),
-- ('duó'),
-- ('féng'),
-- ('gá'),
-- ('hǎn'),
-- ('hē'),
-- ('hǔ'),
-- ('huǎng'),
-- ('hún'),
-- ('kǎ'),
-- ('kào'),
-- ('kěn'),
-- ('kēng'),
-- ('kōng'),
-- ('kōu'),
-- ('kuǐ'),
-- ('kǔn'),
-- ('lā'),
-- ('léng'),
-- ('liǎng'),
-- ('lǐn'),
-- ('lǘ'),
-- ('mà'),
-- ('mèn'),
-- ('miáo'),
-- ('nǎo'),
-- ('nǐ'),
-- ('nián'),
-- ('niǎn'),
-- ('nú'),
-- ('nǔ'),
-- ('nuó'),
-- ('pā'),
-- ('pài'),
-- ('pāng'),
-- ('pēi'),
-- ('piáo'),
-- ('pīng'),
-- ('pó'),
-- ('pù'),
-- ('qiǎng'),
-- ('qiàng'),
-- ('qiǎo'),
-- ('qǐng'),
-- ('qù'),
-- ('quān'),
-- ('rán'),
-- ('rǎn'),
-- ('ráo'),
-- ('rén'),
-- ('ruǎn'),
-- ('sǎ'),
-- ('sà'),
-- ('sāi'),
-- ('sǎn'),
-- ('sǎng'),
-- ('sào'),
-- ('shǎng'),
-- ('shǒu'),
-- ('shuì'),
-- ('suí'),
-- ('sūn'),
-- ('sǔn'),
-- ('tǎ'),
-- ('tàn'),
-- ('tè'),
-- ('tiǎo'),
-- ('tòng'),
-- ('tù'),
-- ('tuì'),
-- ('wàn'),
-- ('wàng'),
-- ('wěn'),
-- ('xìn'),
-- ('xuǎn'),
-- ('yǎng'),
-- ('yé'),
-- ('yìng'),
-- ('yǔn'),
-- ('zāi'),
-- ('zǎi'),
-- ('zāng'),
-- ('zàng'),
-- ('zèng'),
-- ('zhǎng'),
-- ('zhǒng'),
-- ('zhuān'),
-- ('zhuāng'),
-- ('zhūn'),
-- ('zuó'),
-- ('ái'),
-- ('bǎ'),
-- ('bài'),
-- ('bǎng'),
-- ('běn'),
-- ('biào'),
-- ('biē'),
-- ('bié'),
-- ('bìng'),
-- ('cài'),
-- ('cān'),
-- ('cán'),
-- ('cǎn'),
-- ('càn'),
-- ('céng'),
-- ('chāi'),
-- ('chái'),
-- ('chōu'),
-- ('chuài'),
-- ('chuān'),
-- ('chuāng'),
-- ('chuáng'),
-- ('chuō'),
-- ('còu'),
-- ('cuàn'),
-- ('cūn'),
-- ('da'),
-- ('dāi'),
-- ('dǎi'),
-- ('dé'),
-- ('de'),
-- ('dǐng'),
-- ('ē'),
-- ('èr'),
-- ('féi'),
-- ('gèn'),
-- ('gòng'),
-- ('hāi'),
-- ('hái'),
-- ('hǎi'),
-- ('hāo'),
-- ('hēi'),
-- ('hěn'),
-- ('huā'),
-- ('huāng'),
-- ('huàng'),
-- ('huǐ'),
-- ('hùn'),
-- ('huó'),
-- ('jiě'),
-- ('jiōng'),
-- ('kā'),
-- ('kāi'),
-- ('ké'),
-- ('kǒng'),
-- ('kòng'),
-- ('kuà'),
-- ('kuáng'),
-- ('lá'),
-- ('lǐng'),
-- ('lìng'),
-- ('lǒu'),
-- ('mā'),
-- ('má'),
-- ('mǎng'),
-- ('mián'),
-- ('miào'),
-- ('miè'),
-- ('nǎn'),
-- ('nǎng'),
-- ('nào'),
-- ('niàn'),
-- ('niǎo'),
-- ('pān'),
-- ('pāo'),
-- ('pào'),
-- ('piǎo'),
-- ('piē'),
-- ('piě'),
-- ('pǒ'),
-- ('póu'),
-- ('qiā'),
-- ('qià'),
-- ('qìn'),
-- ('quǎn'),
-- ('quē'),
-- ('qún'),
-- ('rǎng'),
-- ('rěn'),
-- ('rǔ'),
-- ('sā'),
-- ('sān'),
-- ('shǎn'),
-- ('shàng'),
-- ('shén'),
-- ('shuài'),
-- ('shuān'),
-- ('shùn'),
-- ('tāi'),
-- ('tiān'),
-- ('tiāo'),
-- ('tiào'),
-- ('tiē'),
-- ('tóu'),
-- ('tǔ'),
-- ('tuān'),
-- ('tuí'),
-- ('tūn'),
-- ('tuǒ'),
-- ('wà'),
-- ('wāng'),
-- ('wèn'),
-- ('xiā'),
-- ('xiáo'),
-- ('xǐng'),
-- ('xiǔ'),
-- ('xuē'),
-- ('yě'),
-- ('yòng'),
-- ('yuē'),
-- ('zài'),
-- ('zhái'),
-- ('zhǎo'),
-- ('zhē'),
-- ('zhóu'),
-- ('zòng'),
-- ('zǔn'),
-- ('zuǒ'),
-- ('áng'),
-- ('āo'),
-- ('ǎo'),
-- ('ba'),
-- ('bái'),
-- ('báo'),
-- ('bei'),
-- ('běng'),
-- ('bī'),
-- ('bí'),
-- ('bǒ'),
-- ('bo'),
-- ('bū'),
-- ('cā'),
-- ('cāi'),
-- ('cāo'),
-- ('cén'),
-- ('chài'),
-- ('chǎo'),
-- ('chē'),
-- ('chě'),
-- ('chèng'),
-- ('chòng'),
-- ('chuāi'),
-- ('chuǎn'),
-- ('chuàn'),
-- ('chuàng'),
-- ('chuī'),
-- ('cú'),
-- ('cuǐ'),
-- ('dáo'),
-- ('děng'),
-- ('diē'),
-- ('diū'),
-- ('dǒng'),
-- ('duān'),
-- ('dǔn'),
-- ('ēn'),
-- ('fǎ'),
-- ('fà'),
-- ('fǎn'),
-- ('fěng'),
-- ('fǒu'),
-- ('gǎ'),
-- ('gǎng'),
-- ('gēn'),
-- ('gèng'),
-- ('guǎ'),
-- ('guāi'),
-- ('guài'),
-- ('guǎng'),
-- ('guàng'),
-- ('hā'),
-- ('hàng'),
-- ('hǎo'),
-- ('hēng'),
-- ('hèng'),
-- ('hǒng'),
-- ('hòng'),
-- ('huān'),
-- ('huǎn'),
-- ('jiáo'),
-- ('juǎn'),
-- ('juē'),
-- ('kài'),
-- ('kuā'),
-- ('kuǎ'),
-- ('kuǎi'),
-- ('kuān'),
-- ('la'),
-- ('làn'),
-- ('le'),
-- ('lèng'),
-- ('liāo'),
-- ('liū'),
-- ('lòng'),
-- ('lōu'),
-- ('lū'),
-- ('luō'),
-- ('ḿ'),
-- ('ma'),
-- ('mái'),
-- ('mǎi'),
-- ('mān'),
-- ('mǎn'),
-- ('mèng'),
-- ('mī'),
-- ('miàn'),
-- ('miē'),
-- ('miù'),
-- ('mú'),
-- ('nā'),
-- ('ná'),
-- ('nǎ'),
-- ('nàn'),
-- ('nāng'),
-- ('náng'),
-- ('nèn'),
-- ('niān'),
-- ('niào'),
-- ('nù'),
-- ('nǚ'),
-- ('nǜ'),
-- ('nüè'),
-- ('òu'),
-- ('pà'),
-- ('pǎi'),
-- ('pén'),
-- ('pèng'),
-- ('piǎn'),
-- ('piàn'),
-- ('pīn'),
-- ('pìn'),
-- ('qié'),
-- ('qǐn'),
-- ('quàn'),
-- ('qūn'),
-- ('ràng'),
-- ('rì'),
-- ('rùn'),
-- ('sài'),
-- ('sāng'),
-- ('sǎo'),
-- ('shěng'),
-- ('shi'),
-- ('shuā'),
-- ('shuāi'),
-- ('shuàn'),
-- ('shǔn'),
-- ('sòu'),
-- ('suān'),
-- ('suàn'),
-- ('tàng'),
-- ('tiàn'),
-- ('tiě'),
-- ('tiè'),
-- ('tōng'),
-- ('tuán'),
-- ('tuī'),
-- ('wǎ'),
-- ('wáng'),
-- ('wèng'),
-- ('xiě'),
-- ('xióng'),
-- ('xiòng'),
-- ('xuě'),
-- ('xuè'),
-- ('yǎ'),
-- ('yō'),
-- ('yóng'),
-- ('zá'),
-- ('zān'),
-- ('zāo'),
-- ('zè'),
-- ('zéi'),
-- ('zhāi'),
-- ('zhěng'),
-- ('zhǒu'),
-- ('zhuā'),
-- ('zhǔn'),
-- ('zǒng'),
-- ('zòu'),
-- ('zū'),
-- ('zuān'),
-- ('zuǎn'),
-- ('zuàn'),
-- ('zuǐ'),
-- ('zuō'),
-- ('á'),
-- ('ǎ'),
-- ('à'),
-- ('a'),
-- ('āng'),
-- ('àng'),
-- ('bāi'),
-- ('běi'),
-- ('béng'),
-- ('biě'),
-- ('biè'),
-- ('bú'),
-- ('cáng'),
-- ('cǎo'),
-- ('cēn'),
-- ('cēng'),
-- ('cèng'),
-- ('chǎi'),
-- ('chào'),
-- ('chěn'),
-- ('chǒng'),
-- ('chòu'),
-- ('chuǎi'),
-- ('chuǎng'),
-- ('chǔn'),
-- ('cū'),
-- ('cuán'),
-- ('cún'),
-- ('cǔn'),
-- ('cùn'),
-- ('cuǒ'),
-- ('dǎ'),
-- ('dà'),
-- ('dē'),
-- ('dēi'),
-- ('děi'),
-- ('dèn'),
-- ('diǎ'),
-- ('duǎn'),
-- ('duī'),
-- ('ě'),
-- ('e'),
-- ('ê̄'),
-- ('ế'),
-- ('ê̌'),
-- ('ề'),
-- ('èn'),
-- ('fā'),
-- ('fàng'),
-- ('fěn'),
-- ('fó'),
-- ('gà'),
-- ('gǎi'),
-- ('gěi'),
-- ('gén'),
-- ('gěn'),
-- ('guǎi'),
-- ('gùn'),
-- ('guò'),
-- ('há'),
-- ('hǎ'),
-- ('hà'),
-- ('hāng'),
-- ('hén'),
-- ('hèn'),
-- ('hng'),
-- ('hōu'),
-- ('hǒu'),
-- ('huài'),
-- ('huo'),
-- ('jia'),
-- ('jie'),
-- ('juě'),
-- ('juè'),
-- ('káng'),
-- ('kāo'),
-- ('kēi'),
-- ('kèn'),
-- ('kǒu'),
-- ('kǔ'),
-- ('kuǎn'),
-- ('kuǎng'),
-- ('kùn'),
-- ('lǎ'),
-- ('lāng'),
-- ('lāo'),
-- ('lēi'),
-- ('lei'),
-- ('lēng'),
-- ('lěng'),
-- ('lī'),
-- ('li'),
-- ('liǎ'),
-- ('liē'),
-- ('liě'),
-- ('līn'),
-- ('lo'),
-- ('lou'),
-- ('lu'),
-- ('luǎn'),
-- ('luàn'),
-- ('lūn'),
-- ('lǔn'),
-- ('lùn'),
-- ('luo'),
-- ('m̀'),
-- ('māng'),
-- ('māo'),
-- ('me'),
-- ('mēn'),
-- ('men'),
-- ('mēng'),
-- ('miāo'),
-- ('mǐng'),
-- ('mìng'),
-- ('mō'),
-- ('mǒ'),
-- ('mōu'),
-- ('mǒu'),
-- ('na'),
-- ('nān'),
-- ('nàng'),
-- ('nāo'),
-- ('né'),
-- ('nè'),
-- ('ne'),
-- ('něi'),
-- ('nèi'),
-- ('néng'),
-- ('ńg'),
-- ('ňg'),
-- ('ǹg'),
-- ('nī'),
-- ('niáng'),
-- ('niàng'),
-- ('niē'),
-- ('nín'),
-- ('nǐng'),
-- ('niū'),
-- ('niú'),
-- ('niù'),
-- ('nòng'),
-- ('nòu'),
-- ('nuǎn'),
-- ('ō'),
-- ('ó'),
-- ('ò'),
-- ('pāi'),
-- ('pǎng'),
-- ('pàng'),
-- ('pǎo'),
-- ('pēn'),
-- ('pèn'),
-- ('pěng'),
-- ('pǐn'),
-- ('po'),
-- ('pōu'),
-- ('pǒu'),
-- ('qiá'),
-- ('qiǎ'),
-- ('qiē'),
-- ('qiě'),
-- ('qiǔ'),
-- ('qu'),
-- ('qué'),
-- ('rāng'),
-- ('rǎo'),
-- ('rào'),
-- ('rě'),
-- ('rè'),
-- ('rēng'),
-- ('réng'),
-- ('rǒng'),
-- ('ròu'),
-- ('ruán'),
-- ('ruí'),
-- ('ruǐ'),
-- ('sàn'),
-- ('sàng'),
-- ('sēn'),
-- ('sēng'),
-- ('shá'),
-- ('shǎ'),
-- ('shāi'),
-- ('shǎi'),
-- ('shài'),
-- ('shang'),
-- ('shǎo'),
-- ('shě'),
-- ('shéi'),
-- ('shéng'),
-- ('shōu'),
-- ('shóu'),
-- ('shuǎ'),
-- ('shuà'),
-- ('shuǎi'),
-- ('shuǎng'),
-- ('shuí'),
-- ('shuǐ'),
-- ('shuō'),
-- ('sǐ'),
-- ('sú'),
-- ('suǐ'),
-- ('tǎo'),
-- ('tào'),
-- ('tēng'),
-- ('tǐ'),
-- ('tìng'),
-- ('tōu'),
-- ('tòu'),
-- ('tuǎn'),
-- ('tuàn'),
-- ('tuǐ'),
-- ('tùn'),
-- ('wá'),
-- ('wa'),
-- ('wāi'),
-- ('wǎi'),
-- ('wài'),
-- ('wěng'),
-- ('wǒ'),
-- ('xǐn'),
-- ('xú'),
-- ('xu'),
-- ('ya'),
-- ('yo'),
-- ('yuǎn'),
-- ('yuě'),
-- ('zǎ'),
-- ('zán'),
-- ('zǎng'),
-- ('záo'),
-- ('zěn'),
-- ('zèn'),
-- ('zha'),
-- ('zhǎi'),
-- ('zháo'),
-- ('zhe'),
-- ('zhuǎ'),
-- ('zhuài'),
-- ('zhuǎn'),
-- ('zhuǎng'),
-- ('zǒu'),
-- ('yi'),
-- ('ji'),
-- ('yu'),
-- ('xi'),
-- ('fu'),
-- ('zhi'),
-- ('qi'),
-- ('yan'),
-- ('wei'),
-- ('jian'),
-- ('bi'),
-- ('ju'),
-- ('wu'),
-- ('xian'),
-- ('jiao'),
-- ('qian'),
-- ('di'),
-- ('hu'),
-- ('zhu'),
-- ('gu'),
-- ('shu'),
-- ('yin'),
-- ('you'),
-- ('jing'),
-- ('pi'),
-- ('xie'),
-- ('hui'),
-- ('chi'),
-- ('jin'),
-- ('ying'),
-- ('zi'),
-- ('yuan'),
-- ('he'),
-- ('xiao'),
-- ('xuan'),
-- ('yao'),
-- ('chan'),
-- ('han'),
-- ('shan'),
-- ('zhen'),
-- ('shen'),
-- ('xun'),
-- ('cheng'),
-- ('huan'),
-- ('mo'),
-- ('si'),
-- ('chu'),
-- ('ling'),
-- ('ge'),
-- ('jue'),
-- ('ke'),
-- ('yun'),
-- ('tong'),
-- ('dan'),
-- ('fei'),
-- ('gui'),
-- ('tan'),
-- ('huang'),
-- ('kui'),
-- ('mi'),
-- ('ti'),
-- ('wan'),
-- ('xiang'),
-- ('yang'),
-- ('yong'),
-- ('lin'),
-- ('pu'),
-- ('qiu'),
-- ('liao'),
-- ('liu'),
-- ('mao'),
-- ('mei'),
-- ('qiao'),
-- ('tang'),
-- ('xing'),
-- ('bao'),
-- ('cha'),
-- ('lian'),
-- ('su'),
-- ('zhou'),
-- ('zhuo'),
-- ('ao'),
-- ('bian'),
-- ('chang'),
-- ('fan'),
-- ('gan'),
-- ('jiu'),
-- ('tuo'),
-- ('dian'),
-- ('du'),
-- ('guan'),
-- ('jiang'),
-- ('qing'),
-- ('quan'),
-- ('ban'),
-- ('chen'),
-- ('ci'),
-- ('fen'),
-- ('hong'),
-- ('ni'),
-- ('ting'),
-- ('zhan'),
-- ('feng'),
-- ('gou'),
-- ('lü'),
-- ('qin'),
-- ('sui'),
-- ('ye'),
-- ('zhang'),
-- ('ai'),
-- ('dai'),
-- ('duo'),
-- ('jun'),
-- ('lan'),
-- ('meng'),
-- ('mu'),
-- ('xiu'),
-- ('yue'),
-- ('biao'),
-- ('hao'),
-- ('lang'),
-- ('liang'),
-- ('peng'),
-- ('she'),
-- ('tao'),
-- ('wen'),
-- ('xia'),
-- ('bu'),
-- ('lao'),
-- ('long'),
-- ('qiang'),
-- ('shao'),
-- ('ta'),
-- ('tu'),
-- ('zhao'),
-- ('an'),
-- ('chou'),
-- ('gong'),
-- ('guo'),
-- ('man'),
-- ('ru'),
-- ('dao'),
-- ('dong'),
-- ('gao'),
-- ('ping'),
-- ('tian'),
-- ('xin'),
-- ('zheng'),
-- ('zuo'),
-- ('chong'),
-- ('die'),
-- ('ding'),
-- ('fang'),
-- ('hou'),
-- ('mian'),
-- ('ren'),
-- ('sha'),
-- ('suo'),
-- ('wo'),
-- ('zao'),
-- ('bang'),
-- ('dun'),
-- ('gang'),
-- ('kan'),
-- ('kuang'),
-- ('min'),
-- ('nie'),
-- ('pan'),
-- ('song'),
-- ('zhong'),
-- ('bin'),
-- ('cuo'),
-- ('dang'),
-- ('juan'),
-- ('kun'),
-- ('lie'),
-- ('tai'),
-- ('tiao'),
-- ('bing'),
-- ('cui'),
-- ('er'),
-- ('geng'),
-- ('miao'),
-- ('pei'),
-- ('rong'),
-- ('sheng'),
-- ('sou'),
-- ('wang'),
-- ('chao'),
-- ('diao'),
-- ('gai'),
-- ('hua'),
-- ('kai'),
-- ('mang'),
-- ('nao'),
-- ('ou'),
-- ('pian'),
-- ('piao'),
-- ('chun'),
-- ('cong'),
-- ('deng'),
-- ('dou'),
-- ('hai'),
-- ('lai'),
-- ('qie'),
-- ('que'),
-- ('shou'),
-- ('ze'),
-- ('zhuan'),
-- ('zong'),
-- ('gua'),
-- ('hun'),
-- ('ku'),
-- ('ming'),
-- ('nian'),
-- ('pa'),
-- ('pang'),
-- ('xue'),
-- ('zan'),
-- ('zu'),
-- ('beng'),
-- ('cai'),
-- ('can'),
-- ('duan'),
-- ('heng'),
-- ('kang'),
-- ('kuai'),
-- ('nai'),
-- ('pao'),
-- ('tun'),
-- ('zeng'),
-- ('bai'),
-- ('ben'),
-- ('chuan'),
-- ('cu'),
-- ('ga'),
-- ('guang'),
-- ('jiong'),
-- ('luan'),
-- ('mai'),
-- ('nan'),
-- ('ning'),
-- ('pai'),
-- ('pin'),
-- ('xiong'),
-- ('zhai'),
-- ('cao'),
-- ('che'),
-- ('chui'),
-- ('fa'),
-- ('kao'),
-- ('kou'),
-- ('lun'),
-- ('nu'),
-- ('nuo'),
-- ('rang'),
-- ('sa'),
-- ('shuo'),
-- ('tui'),
-- ('zai'),
-- ('zhuang'),
-- ('zhui'),
-- ('chai'),
-- ('hang'),
-- ('kong'),
-- ('mou'),
-- ('niu'),
-- ('qiong'),
-- ('rui'),
-- ('sao'),
-- ('shuang'),
-- ('teng'),
-- ('zou'),
-- ('zun'),
-- ('chuang'),
-- ('chuo'),
-- ('cuan'),
-- ('nong'),
-- ('qia'),
-- ('ran'),
-- ('ruo'),
-- ('se'),
-- ('sun'),
-- ('weng'),
-- ('za'),
-- ('zang'),
-- ('cang'),
-- ('dui'),
-- ('gun'),
-- ('kua'),
-- ('leng'),
-- ('rou'),
-- ('san'),
-- ('tuan'),
-- ('zui'),
-- ('bie'),
-- ('ce'),
-- ('cun'),
-- ('gen'),
-- ('huai'),
-- ('ka'),
-- ('nang'),
-- ('rao'),
-- ('sang'),
-- ('shuai'),
-- ('shui'),
-- ('zhun'),
-- ('ceng'),
-- ('guai'),
-- ('hen'),
-- ('ken'),
-- ('kuo'),
-- ('lüe'),
-- ('mie'),
-- ('niao'),
-- ('pie'),
-- ('qun'),
-- ('ruan'),
-- ('sai'),
-- ('shuan'),
-- ('shun'),
-- ('tie'),
-- ('tou'),
-- ('zuan'),
-- ('ang'),
-- ('chuai'),
-- ('keng'),
-- ('nü'),
-- ('pou'),
-- ('suan'),
-- ('te'),
-- ('cen'),
-- ('cou'),
-- ('en'),
-- ('ha'),
-- ('hei'),
-- ('kuan'),
-- ('pen'),
-- ('shai'),
-- ('shua'),
-- ('wai'),
-- ('zhua'),
-- ('ca'),
-- ('dei'),
-- ('diu'),
-- ('fou'),
-- ('m'),
-- ('miu'),
-- ('nei'),
-- ('nen'),
-- ('niang'),
-- ('nüe'),
-- ('o'),
-- ('re'),
-- ('reng'),
-- ('ri'),
-- ('run'),
-- ('zei'),
-- ('zen'),
-- ('den'),
-- ('dia'),
-- ('ê'),
-- ('fo'),
-- ('gei'),
-- ('kei'),
-- ('lia'),
-- ('neng'),
-- ('ng'),
-- ('nin'),
-- ('nou'),
-- ('nuan'),
-- ('sen'),
-- ('seng'),
-- ('shei'),
-- ('zhuai')