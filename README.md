## Arabam.com android stajer challenge ##

[Challenge detayı](CHALLENGE_README.md)

 ### Projede 1 adet activity kullandım. Bütün ekranları için fragmentar oluşturdum. Fragmentların hepsini activityde yönettim.

* List Fragment

   * Araba listesini ve stateleri tutmak için ViewModel oluşturdum. 
   ViewModel kullanma sebebim fragmentların lifecyclelarında sürecinde başına bir şey gelmesi durumunda datanın kaybolup bir hataya yol açmasın diye.
   * Paging için "androidx.paging:paging kütüphanesini kullandım çünkü kendi başına halledebiliryor ve bu benim işimi kolaylaştırdı.
   * HTTP isteklerini verilen API'den alabilmek için retrofit kullandım
   * Araba listesi için recyclerview kullandım 
     çünkü recyclerview diğer alternatiflerine göre(Listview..) viewleri oluşturuken daha verimli olduğunu düşündüğüm için.

* Detail Fragment
   
   * Bu fragment tıpkı list fragment gibi viewmodel kullandım aynı sebeblerden.
   * Gözükmesi gereken fotograflar için viewpager kullandım. Birden fazla image göstermek için kullanışlı olduğunu düşünüyorum.
   * Propertiesleri recyclerview kulladım çünkü gelecek olan listenin tam olarak nasıl olduğunu bilmediğim için recyclerview mantıklı buldum.

* Full Screen Image Fragment
   
   * Bu fragmentta viewmodel kullanmadım, sadece tıklanan fotografın gözükmesi işlemi için gerek olmadığını düşündüm. 

### Varsayımlarım
* proreties bir tane elemanı bile boş olursa göstermedim çünkü eksik datayı göstermek kötü olur diye düşündüm
* location,title,model name, datası gelmeme ihtimaline karşı default text atadım
* Priceformatted datası gelmezse price datasını gösterilmesini sağladım.
* Dateformatted datası gelmezse yerine date datasını gösterilmesini sağladım
* Imageların Url sıkıntı olması durumda default image kullandım.    

### Zamanım olsa
* Ui daha güzel hale getirirdim
* Bonusları yapmak isterdim
* Toolbar ı kullanarak iyi bir ui yapardım
* DateBinding kullanmak isterdim

