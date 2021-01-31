package com.arabam.android.assigment.repository

import com.arabam.android.assigment.models.CarItem
import com.arabam.android.assigment.models.Location

class CarRepository {
    companion object {

        fun getCarList(): List<CarItem> {
            val carList = mutableListOf<CarItem>()
            carList.add(
                    CarItem(
                            15207658,
                            "Sahibinden Suzuki SX4 1.6 GLX 2010 Model",

                            "SX4 1.6 GLX Manuel",
                            106000.0,
                            null,
                            "2020-11-11T00:00:00",
                            "11 Kasım 2020",
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/08/13/15207658/bb8fbec7-765c-48ef-96cd-e2935b72947b_image_for_silan_15207658_800x600.jpg",
                            Location("Mersin", "Icel")
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15948868/9558803d-c0e5-4966-8f1d-3a7a04d7fd9c_image_for_silan_15948868_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15943485/343f8e5d-e92c-4e07-b79d-e4af75b50e9f_image_for_silan_15943485_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/09/12/15456643/3c5b2dd1-856f-406f-8d10-1450061d1966_image_for_silan_15456643_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/12/15954889/18b8ef36-ec80-4ca0-8b9c-d4f63f21a014_image_for_silan_15954889_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/11/15949335/ee9754d4-536e-46a7-acb4-57ab749be576_image_for_silan_15949335_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/12/15954751/cad6412e-5500-45fe-84d0-5b57e0d7eb05_image_for_silan_15954751_800x600.jpg",
                            Location("Mersin", "Icel"))
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
                            Location("Mersin", "Icel"))
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
                            "https://arbstorage.mncdn.com/ilanfotograflari/2020/11/12/15952894/18b3acfb-8a22-4512-96f5-924cea110ba7_image_for_silan_15952894_800x600.jpg",
                            Location("Mersin", "Icel"))
            )

            return carList
        }
    }
}