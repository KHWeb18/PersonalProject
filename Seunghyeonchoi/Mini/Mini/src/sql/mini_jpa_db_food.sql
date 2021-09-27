-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mini_jpa_db
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `food_no` int NOT NULL AUTO_INCREMENT,
  `age_select` varchar(64) NOT NULL,
  `calcium` varchar(64) NOT NULL,
  `coat` varchar(64) NOT NULL,
  `diarhea` varchar(64) NOT NULL,
  `fat` varchar(64) NOT NULL,
  `fiber` varchar(64) NOT NULL,
  `gluten_free` varchar(64) NOT NULL,
  `grade_select` varchar(64) NOT NULL,
  `hairball` varchar(64) NOT NULL,
  `introduce` varchar(160) DEFAULT NULL,
  `kcal` varchar(64) NOT NULL,
  `mineral` varchar(64) NOT NULL,
  `moisture` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `palatability` varchar(64) NOT NULL,
  `phosphorus` varchar(64) NOT NULL,
  `protein` varchar(64) NOT NULL,
  PRIMARY KEY (`food_no`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'ADULT','1.4','none','none','20','4','TRUE','HOLISTIC','TRUE','우리 냥이 하루 건강식이 고민이라면?\n건강한 피부유지에 도움을 주는 연어와 소화기능 개선에 도움을 주는 렌틸콩이 들어간 ANF그레인프리 연어&노란콩⠀\n이제부터 우리 댕냥이 건강식 걱정은 ANF 그레인프리에게 맡겨주세요','4000','10','10','ANF 캣 홀리스틱 그레인프리(연어와 노란콩)','none','0.8','33'),(2,'ADULT','1.1','none','none','18','9','TRUE','HOLISTIC','TRUE','웰츠 캣 헤어볼 케어는 영양소가 풍부하고 면역력을 강화시키며, 저칼로리 웰빙식품의 재료인 렌틸콩, 병아리콩, 바나나, 호박, 고구마를 사용한 슈퍼푸드입니다. ','3900','9','10','웰츠 캣 헤어볼 케어','none','0.85','37'),(3,'ADULT','1.0','TRUE','TRUE','16','5','TRUE','HOLISTIC','TRUE','퍼시캣 치킨&칠면조 레시피는 휴먼그레이드 등급의 치킨과 칠면조를 주원료로 만든 사료입니다. 섬유질이 풍부하여 체내에 쌓인 헤어볼 배출에 도움을 주며, 검증된 신선한 육류만을 사용하여 충분한 영양 공급에 효과적입니다.','3550','7.5','10','힐스 사이언스 다이어트 어덜트캣 헤어볼컨트롤','TRUE','0.8','36'),(4,'ADULT','1','TRUE','TRUE','19','4.5','none','HOLISTIC','TRUE','올가밀 홀리스틱 캣35 치킨은 청정지역 호주의 신선한 원료로 만든 제품입니다. 필수 비타민과 미네랄이 풍부하고 동물성 단백질을 사용하여 영양이 필요한 어린 고양이, 임신묘, 수유모 등 모든 연령의 고양이에게 두루 적합한 영양을 공급해주는 기능성 사료입니다. ','','7','10','올가밀 홀리스틱 캣35 치킨','TRUE','0.8','35'),(5,'','1','TRUE','TRUE','19','4.5','TRUE','HOLISTIC','TRUE','올가밀 홀리스틱 캣35 씨푸드&참치 1kg은 필수 비타민과 미네랄이 풍부하여 모든 고양이를 위한 완벽한 식단으로, 참치의 단백질 성분이 건강을 유지하여 주고 활동에 필요한 근육의 발달에 도움을 줍니다. ','0','7','10','올가밀 홀리스틱 캣35 씨푸드&참치','TRUE','0.8','36'),(6,'ADULT','1','none','none','15','5','TRUE','HOLISTIC','TRUE','퍼시캣 연어 레시피는 휴먼그레이드 등급의 연어를 주원료로 만든 사료입니다. 섬유질이 풍부하여 체내에 쌓인 헤어볼 배출에 도움을 주며, 연어의 오메가 지방산이 피부 및 피모 개선에 효과적입니다. 설사, 소화불량, 체중조절 등에 좋은 병아리콩과 크랜베리를 첨가하였습니다','3550','8.5','10','퍼시캣 연어 레시피','none','0.8','35'),(7,'ADULT','1','none','none','15','8','none','HOLISTIC','none','나인케어 인도어 사료는 얼리지 않은 생고기 등 홀리스틱급 원료를 사용한 프리미엄 사료 입니다. 중국산 재료 및 고기 부산물은 첨가하지 않았습니다. 녹차 추출물 함유로 치석 형성을 억제하며, 카모마일 추출물 함유로 스트레소 감소에 도움을 줍니다.','','9','10','스마트하트 나인케어 인도어','none','0.8','32'),(8,'','1.3','none','none','22','1.5','none','HOLISTIC','none','레오나르도 어덜트 라이트 캣 푸드는 1년 이상의 과체중 성묘에게 적합한 건식사료입니다. 가금 생육을 사용하여 건강한 단백질을 제공하며, 저열량 사료로 고양이의 체중 조절에 효과적입니다. 또한, 사과의 식이섬유가 변비 완화에 도움을 줍니다. ','4278','8.5','10','레오나르도 라이트','none','0.94','34'),(9,'ADULT','1.6','TRUE','none','18','3','TRUE','HOLISTIC','none','아카나 와일드 프레이리 캣은 캐나다에서 자연 방목하여 기른 육류와 자연산 생선, 계란을 사용하여 만든 사료입니다. 모든 고양이가 선천적으로 필요로 하는 육류와 단백질이 풍부한 식품이며, 오메가 3&6를 함유하여 피부와 피모 건강에 도움을 줍니다. ','3930','9','10','아카나 와일드 프레이리 캣 ','none','1.2','36'),(10,'ADULT','0.9','none','none','18','6.5','TRUE','HOLISTIC','none','퓨어비타 그레인프리 치킨은 미국 AAFCO가 규정하는 영영등급을 사용하였으며, 고양이의 알러지를 유발할 수 있는 곡물을 첨가하지 않고 순수한 닭고기와 맛과 영양이 풍부한 과일과 야채가 함께 어우러진 사료로 성묘와 어린 고양이에게도 적합한 전연령 사료입니다. ','3992','7.5','10','퓨어비타 그레인프리 치킨','none','1.3','32'),(11,'ADULT','1','TRUE','none','15','4','TRUE','HOLISTIC','none','ANF 캣 홀리스틱 헬시어덜트는 자연 원료를 그대로 사용한 휴먼그레이드 등급 사료입니다. 크랜베리 함유로 유해물질 중화, 요로계 건강에 도움을 주고, 건강한 피부와 피모 유지에 도움을 주는 오메가3&6를 함유하고 있습니다. 또한, 미국 최상등급 펫푸드 공장에서 제조하였습니다.','3870','8','10','ANF 캣 홀리스틱 헬시어덜트','none','0.8','32'),(12,'ADULT','1','TRUE','TRUE','15','5','TRUE','HOLISTIC','none','퍼시캣 연어&치킨 레시피는 연어와 닭고기를 주원료로 만든 건식 사료입니다. 오메가 3와 6가 함유되어 모질 개선에 도움을 주고, 장내유익균을 증가시켜 배변활동에 탁월한 프락토올리고당을 첨가했습니다.','3550','7','10','퍼시캣 연어&치킨 레시피','none','0.8','36'),(13,'ADULT','1.3','TRUE','TRUE','22','1.5','none','HOLISTIC','none','레오나르도 어덜트 오리 캣 푸드는 1년 이상의 장모인 성묘에게 적합한 건식사료입니다. 오리 생육을 사용하여 건강한 피부모질 관리에 적합하며, 캐럽 콩깍지를 함유하여 효과적인 소화 흡수를 돕습니다.','4278','8.5','10','레오나르도 오리','none','0.94','34'),(14,'ADULT','1','TRUE','TRUE','12','4','none','HOLISTIC','none','ANF 캣 홀리스틱 헬시웨이트는 자연 원료를 그대로 사용한 휴먼그레이드 등급 사료입니다. 프리, 프로바이오틱스를 함유하여 위, 장건강 및 변 상태 개선에 도움을 주고, 건강한 피부와 피모 유지에 도움을 주는 오메가3&6를 함유하고 있습니다.','3450','8','10','ANF 캣 홀리스틱 헬시웨이트','none','0.8','33'),(15,'ADULT','0.8','none','TRUE','12','5','none','ORGANIC','TRUE',' 고양이에게 필요한 영양공급을 위해 육류 원료의 비중을 강화하고 곡물을 최소화한 영양식품입니다. 유전자 변형물질, 항생제, 살충제, 호르몬제, 합성착색료 그리고 화학보존료와 같은 유해물질이 포함되지 않은 깨끗하고 안전한 원료로 만들어집니다.','3611','12','11','ANF 유기농 6Free 인도어 어덜트','none','0.5','34'),(16,'ADULT','1','none','TRUE','15','6','none','ORGANIC','none','뉴트리나 리얼오플러스 캣 인도어는 실내에서 주로 생활하는 고양이를 위한 기능성을 강화한 자연 그대로의 유기농 인증 사료입니다. 필수 영양분인 타우린, 아르기닌을 함유하여 눈과 심장 건강에 도움을 주며, 방광염 등 요로계 질환 예방에 보조적인 도움을 주는 크랜베리를 첨가하였습니다','0','12','11','뉴트리나 리얼오플러스 캣 인도어','none','0.5','30'),(17,'ADULT','1.4','none','none','15','4.5','none','ORGANIC','none','','0','9','10','게더 프리 에이커 캣 치킨','none','0.6','29'),(18,'KITTEN','0.9','none','none','14','7','TRUE','HOLISTIC','none','뉴트로 내추럴 초이스 키튼 닭고기와 현미는 자라나는 고양이를 위한 성장기 영양식품 입니다. 혼합 천연 섬유소로 헤어볼 형성을 억제해주고, 천연 오일이 풍부하게 함유되어 건강한 피부와 부드럽고 윤기 나는 모질을 만들어 줍니다.','3613','8.3','10','뉴트로 내추럴 초이스 키튼 닭고기와 현미','none','0.5','33'),(19,'KITTEN','1.1','none','none','20','5','TRUE','HOLISTIC','none','이즈칸 캣 그레인프리 키튼은 알러지를 유발할 수 있는 쌀, 보리, 밀, 옥수수 등의 곡물을 전혀 사용하지 않고 순수한 닭고기와 연어 및 풍부한 비타민이 함께 어우러진 완벽한 식품입니다.','4100','10','12','이즈칸 캣 그레인프리 키튼','none','0.7','36'),(20,'KITTEN','0.5','none','none','6','4','none','SUPERPREMIUM','none','CP 클래식 키튼은 어린 고양이의 최적 성장 발달을 위하여 우유와 계란에서 추출한 엄선된 단백질원을 사용하였습니다. 고품격의 생선오일로부터 추출한 양질의 필수 지방산은 건강한 피부와 윤기 나는 피모를 지켜줍니다. ','0','10','10','CP 클래식 키튼','none','0.1','30'),(21,'ADULT','1.4','none','none','14','8','TRUE','HOLISTIC','none','웰츠 캣 저지방 다이어트는 영양소가 풍부하고 면역력을 강화시키며, 저칼로리 웰빙식품의 재료인 렌틸콩, 병아리콩, 바나나, 호박, 고구마를 사용한 슈퍼푸드입니다. ','3400','9','10','웰츠 캣 저지방 다이어트','none','1.1','37'),(22,'ADULT','0','TRUE','TRUE','22.5','3','TRUE','HOLISTIC','none','네이처스 버라이어티 생식본능 토끼는 고양이에게 자연이 의도한 방식의 영양을 제공합니다. 이 제품은 대부분의 식품 알레르기에 대한 증상 완화를 제공하고, 이상적인 체중에 도달하고 그 체중을 유지하는데 도움을 줍니다.','4346','0','9','네이처스 버라이어티 생식본능 토끼','TRUE','0','40.5'),(23,'ADULT','0.6','TRUE','TRUE','12','5','TRUE','HOLISTIC','TRUE','저지방 고단백으로 체중 조절 및 헤어볼 예방에 도움을 주며, 중성화 수술 후 체중 관리에도 효과적입니다. 낮은 수준의 마그네슘, 칼슘, 인 함량과 크랜베리 첨가로 하부 요로계 질환(FLUTD) 예방에 도움을 주며, 풍부한 오메가 지방산이 피부 및 피모 건강 개선에 효과적입니다.','3561','10','10','웰니스 코어 그레인프리 인도어','none','0.5','38'),(24,'SENIOR','0.95','none','none','16','4.5','TRUE','HOLISTIC','TRUE','이즈칸 캣 그레인프리 시니어는 알러지를 유발할 수 있는 쌀, 보리, 밀, 옥수수 등의 곡물을 전혀 사용하지 않고 순수한 생연어와 생닭고기, 병아리콩 등이 함께 어우러진 완벽한 식품입니다. ','3800','8','10','이즈칸 캣 그레인프리 시니어','none','0.8','30'),(25,'SENIOR','0.57','TRUE','none','15.5','6.5','none','SUPERPREMIUM','TRUE','체내 생성이 불가능한 필수 아미노산 타우린이 눈과 심장 건강에 도움을 주며, 천연 섬유소가 헤어볼 감소 및 형성 예방에 효과적입니다. 오메가3&6 지방산이 피부 및 피모 개선에 도움을 주며, 헤어볼이 잘 생기는 7세 이상의 노령묘, 특별한 장 건강 관리가 필요한 반려묘에게 적합','3907','10.7','8','힐스 사이언스다이어트 어덜트 7','none','0.48','28.5'),(26,'SENIOR','1','none','none','13','4','TRUE','HOLISTIC','TRUE','하림펫푸드 더리얼 캣 그레인프리 크런치 시니어 닭고기는 양질의 단백질을 제공하는 신선한 생닭고기를 주원료로 만든 노령묘 전용 사료입니다. 사람이 섭취할 수 있는 100% 휴먼 그레이드 등급의 원료만을 사용하였으며, 곡물을 넣지 않아 알러지 발생을 최소화하였습니다. ','3310','10','10','하림펫푸드 더리얼 캣 그레인프리 크런치 시니어 닭고기','none','1','28');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-15  2:27:56
