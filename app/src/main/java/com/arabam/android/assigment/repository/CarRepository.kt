package com.arabam.android.assigment.repository

import com.arabam.android.assigment.models.*

class CarRepository {
    companion object {

        fun getCarList(): List<CarItem> {
            val carList = mutableListOf<CarItem>()
            carList.add(
                CarItem(
                    15207658,
                    "Sahibinden Suzuki SX4 1.6 GLX 2010 Model",
                    "SX4 1.6 GLX Manuel",
                    106000.21,
                    null,
                    "2020-11-11T00:00:00",
                    "11 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/08/13/15207658/bb8fbec7-765c-48ef-96cd-e2935b72947b_image_for_silan_15207658_{0}.jpg",
                    Location("Kocaeli", "İzmit"),
                    Category(25130, "otomobil/suzuki-sx4-1-6-glx"),
                    listOf(
                        Properties("km", "126000"),
                        Properties("color", ""),
                        Properties("year", "2010")
                    )
                )
            )
            carList.add(
                CarItem(
                    15948868,
                    "HATASIZ BOYASIZ Fiat Egea 1.3 Multijet Easy 2017 Model ",
                    "Egea 1.3 MultiJet Easy Manuel",
                    138000.0,
                    "138000 TL",
                    "2020-11-11T00:00:00",
                    "11 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15948868/9558803d-c0e5-4966-8f1d-3a7a04d7fd9c_image_for_silan_15948868_{0}.jpg",
                    Location("Kastamonu", "Merkez"),
                    Category(17797, "otomobil/fiat-egea-1-3-multijet-easy"),
                    listOf(
                        Properties("km", "79000"),
                        Properties("color", "Beyaz"),
                        Properties("year", "2017")
                    )
                )
            )
            carList.add(
                CarItem(
                    15943485,
                    "2020 SKODA SCALA ( senetle taksitlendirme seçengimiz vardır )",
                    "Scala 1.6 TDI SCR Premium DSG",
                    309750.0,
                    "309750 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15943485/343f8e5d-e92c-4e07-b79d-e4af75b50e9f_image_for_silan_15943485_{0}.jpg",
                    Location("İstanbul", "Üsküdar"),
                    Category(82986, "otomobil/skoda-scala-1-6-tdi-premium"),
                    listOf(
                        Properties("km", "0"),
                        Properties("color", "Gri"),
                        Properties("year", "2020")
                    )
                )
            )
            carList.add(
                CarItem(
                    15456643,
                    "Sahibinden Dacia Logan 1.5 dCi Ambiance 2008 Model",
                    "Sahibinden Dacia Logan 1.5 dCi Ambiance 2008 Model",
                    51750.0,
                    "51750 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/09/12/15456643/3c5b2dd1-856f-406f-8d10-1450061d1966_image_for_silan_15456643_{0}.jpg",
                    Location("Bursa", "Kestel"),
                    Category(8035, "otomobil/dacia-logan-1-5-dci-ambiance"),
                    listOf(
                        Properties("km", "267000"),
                        Properties("color", "Beyaz"),
                        Properties("year", "2008")
                    )
                )
            )
            carList.add(
                CarItem(
                    15954889,
                    "GÜVENOĞLU OTOMOTIVDEN TEMİZ BMV3.20 D",
                    "3 Serisi 320d Otomatik",
                    118000.0,
                    "118000 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/12/15954889/18b8ef36-ec80-4ca0-8b9c-d4f63f21a014_image_for_silan_15954889_{0}.jpg",
                    Location("Konya", "Karatay"),
                    Category(23469, "otomobil/bmw-3-serisi-320d-standart"),
                    listOf(
                        Properties("km", "490000"),
                        Properties("color", "Siyah"),
                        Properties("year", "2007")
                    )
                )
            )
            carList.add(
                CarItem(
                    15949335,
                    "Sahibinden Volkswagen Passat 2.0 TDi BlueMotion Comfortline 2015 Model    Bütün ağir bakimlari  yetkili  servis doğuş otoda yapilmiş sifir akü sifir",
                    "Passat 2.0 TDI BMT Comfortline DSG",
                    335000.0,
                    "335000 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15949335/ee9754d4-536e-46a7-acb4-57ab749be576_image_for_silan_15949335_{0}.jpg",
                    Location("İstanbul", "Avcılar"),
                    Category(11654, "otomobil/volkswagen-passat-2-0-tdi-bluemotion-comfortline"),
                    listOf(
                        Properties("km", "132000"),
                        Properties("color", ""),
                        Properties("year", "2015")
                    )
                )
            )
            carList.add(
                CarItem(
                    15954751,
                    "Sahibinden Fiat Linea 1.6 Multijet Lounge 2013 Model",
                    "Linea 1.6 MultiJet Lounge Manuel",
                    117000.0,
                    "117000 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/12/15954751/cad6412e-5500-45fe-84d0-5b57e0d7eb05_image_for_silan_15954751_{0}.jpg",
                    Location("İstanbul", "Kağıthane"),
                    Category(18470, "otomobil/fiat-linea-1-6-multijet-lounge"),
                    listOf(
                        Properties("km", "78400"),
                        Properties("color", ""),
                        Properties("year", "2013")
                    )
                )
            )
            carList.add(
                CarItem(
                    15935112,
                    "Sahibinden Volkswagen Polo 1.0 Comfortline 2018 Model ",
                    "Polo 1.0 TSI Comfortline DSG",
                    175000.0,
                    "175000 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/10/15935112/45d92936-6d44-42b3-aa64-5e41a3c18278_image_for_silan_15935112_800x600.jpg",
                    Location("Sakarya", "Hendek"),
                    Category(61575, "otomobil/volkswagen-polo-1-0-comfortline"),
                    listOf(
                        Properties("km", "78000"),
                        Properties("color", ""),
                        Properties("year", "2018")
                    )
                )
            )
            carList.add(
                CarItem(
                    15952894,
                    "Sahibinden Volkswagen Bora 1.6 Comfortline Variant 2001 Model ",
                    "Bora 1.6 Comfortline Manuel",
                    57500.0,
                    "57500 TL",
                    "2020-11-12T00:00:00",
                    "12 Kasım 2020",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/10/15935112/45d92936-6d44-42b3-aa64-5e41a3c18278_image_for_silan_15935112_{0}.jpg",
                    Location("Hatay", "İskenderun"),
                    Category(12848, "otomobil/volkswagen-bora-1-6-comfortline-variant"),
                    listOf(
                        Properties("km", "260000"),
                        Properties("color", "Yeşil (metalik)"),
                        Properties("year", "2001")
                    )
                )
            )

            return carList
        }

        fun getCarDetail(): CarDetail {

            return CarDetail(
                15943485,
                "2020 SKODA SCALA ( senetle taksitlendirme seçengimiz vardır )",
                "Scala 1.6 TDI SCR Premium DSG",
                309750.0,
                "309750 TL",
                "2020-11-11T00:00:00",
                "11 Kasım 2020",
                listOf(
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/08/13/15207658/bb8fbec7-765c-48ef-96cd-e2935b72947b_image_for_silan_15207658_{0}.jpg",
                    "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15943485/73cb38ca-a6ce-465d-804d-3ba665610f54_image_for_silan_15943485_{0}.jpg"
                ),
                Location("İstanbul", "Üsküdar"),
                Category(82986, "otomobil/skoda-scala-1-6-tdi-premium"),
                listOf(
                    Properties("km", "0"),
                    Properties("color", "Gri"),
                    Properties("year", "2020"),
                    Properties("gear", "Yarı Otomatik"),
                    Properties("fuel", "Dizel")
                ),
                UserInfo(548787, "Amelia Bowman", "9000061415", "9000061415"),
                ""
            )
        }
    }

}