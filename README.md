## Arabam.com android stajyer challenge ##

[Challenge detayı](CHALLENGE_README.md)

 ### Projede 1 adet activity kullandım. Uygulama içindeki ekranlar için fragmentları kullandım. Fragmentların hepsini activityde yönettim. Uygulamanın içinde üç ekran var bunları aşağıda listeledim.

* Listeleme ekranı

   * Araba listesini ve statelerini tutmak için ViewModel oluşturdum. 
   * ViewModel kullanma sebebim fragmentların lifecyclelarında yok edilip tekrar oluşturulması veya benzeri durumlarda datanın kaybolup bir hataya yol açmasını engelemek için.
   * Viewmodel içindeki datalara erişim için livedata kullandım. Datalara erişirken lifecyclerı daha rahat handle edebilmek için.
   * Pagination için "androidx.paging:paging" kütüphanesini kullandım. Çünkü bu kütüphane paginationın büyük kısmını kendisi hallediyor ve bu benim işimi kolaylaştırdı.
   * HTTP isteklerini verilen API'den data alabilmek için retrofit kullandım.
   * Araba listesi göstermek için recyclerview kullandım. Çünkü recyclerview diğer alternatiflerine göre(Listview...) viewleri oluşturuken daha performanslı olduğunu düşündüğüm için.

* Detay ekranı
   
   * Bu ekranda da datayı tutmak için viewmodel kullandım. 
   * Arabanın fotografları göstermek için viewpager kullandım. Birden fazla image göstermek için kullanışlı olduğunu düşünüyorum.
   * Propertiesleri göstermek için recyclerview kulladım. Çünkü propertyler bize liste olarak geliyor.

* Tam ekran fotoğraf ekranı
   
   * Bu ekran detay sayfasındaki fotoğrafa tıklandığında fotoğrafı tam ekran göstermek için kullanıldım.
   * Bu ekranda viewmodel kullanmadım, sadece Urli string olarak bundledan aldığım ve başka bir data olmadığı için gerek olmadığını düşündüm.

### Varsayımlarım

* Detay ekranında ki popertylerden içinde elemanı eksik olan propetyleri göstermedim. Çünkü eksik datalı propertyler kötü gözükür diye düşündüm.
* location,title,model name datası gelmeme ihtimaline karşı default text atadım.
* Priceformatted datası gelmezse price datasını gösterilmesini sağladım.
* Dateformatted datası gelmezse yerine date datasını gösterilmesini sağladım
* Image listesi içindeki null URLleri çıkarttım.
* Liste ekranında fotoğraflarda büyük çözünülğe ihtiyaç duyulmadığından 580x435 çözünürlüğünü kullandım.
* Detay ekranında liste ekranından büyük ama en yüksek olmasına gerek olmadığını düşündüm. 800x600 çözünürlüğü kullandım.
* Tam ekranda da en yüksek çözünürlüğü kullandım 1920x1080.
* Fotoğrafların çözünürlüğünü değiştirdiğim zaman fotoğrafların var olduğunu varsaydım. Ama bazı arabaların en yüksek çözünürlükte fotoğrafları yoktu.

### Zamanım olsa
* UI daha güzel hale getirirdim.
* Bonus olarak sadece tam ekran fotoğraf göstermeyi yaptım. Diğerlerini de yapmak isterdim.
* Toolbarı daha iyi kullanmak isterdim.
* DataBinding kullanmak isterdim.
* Test eklerdim.
* Yüksek çözünürlüğü olamayan fotoğraflar için düşük çözünürlüğe geçmeyi yapabilirdim.

### Yapılanlar

#### Listing Page ####
- [x] We expect to see the list of vehicles on the page.
- [x] Vehicle image that returns from the listing response must also be shown in the list.
- [x] We expect to see pagination is implemented on the list page
- [x] The user should be directed to the detail page when selecting one of the results listed in the vehicle list.

###### Listing Page Bonus ######
- [ ] You can apply filters for the list page. For example,  `minDate `,  `maxDate`, or  `categoryId` etc. You can find it in our API docs. For the design concern, you can use bottomsheet, different fragment, or dialog for the filter page.
- [ ] You can apply sort with price, date, or year. We are supporting 3 different sort types.

##### Detail Page #####
- [x] We expect to see the selected vehicle on the page.
- [x] Vehicle image that returns from the detail response must also be shown on top of the page.
- [x] There is no obligation about detail page design and which information to be shown. You can configure this screen as you like.

###### Detail Page Bonus ######
- [x] When a photo is tapped, it could be shown on a full screen.
- [ ] A component for viewing user information and CTA for calling the user's phone number.


