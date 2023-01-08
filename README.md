# week-4-sinemguler
week-4-sinemguler created by GitHub Classroom

Kullanıcılar, bu sistem üzerinden ilan oluşturabilir, düzenleyebilir, silebilir 
ve detaylarına ulaşabilir. Kendi ilanlarını aktif ve pasif duruma getirebilir ve paket 
satın alıp kendi ilanları için kullanabilir.

Ürün: İlan Yayınlama Hakkı
Paket, 10 Adet ilan yayınlama hakkı içerir, bir aylık geçerlilik süresi vardır. 
Paketi olmayan veya paketin geçerlilik süresi bitmiş kullanıcılar ilan 
yayınlayamazlar. Kullanıcılar paket geçerliliği dolmadan yeni paket alabilir. Bu 
durumda yeni geçerlilik tarihi, kalan geçerlilik tarihinin üzerine bir ay olarak 
eklenerek bulunmalıdır

***Kullanıcılar aşağıdaki işlemleri gerçekleştirebilmelidir.***

- İlan yayınlama sadece sisteme giriş yapan kullanıcı yapabilmeli
- Aktif ilanlarını görüntüleyebilmeli
- Pasif ilanlarını görüntüleyebilmeli
- Satın aldıkları paketleri(ürünleri) görebilmeli
- Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilmeli
- Kullancıların aldıkları ürünler ödeme işlemi başarılı olduktan sonra tanımlanmalı ve bu işlem asenkron yapılmalı

***Kullanılacak Teknolojiler;***
- Java 8
- JUnit 5
- Spring Boot
- Restfull
- MySQL / Postgre / MongoDb
- RabbitMQ
- Microservice mimarisi

***Sistem Kabulleri;***
1. Ürünler, yukarıda belirtilen şekilde sistemde hali hazırda tanımlıdır. Ürün 
oluşturmak için yeni bir servis yazımına gerek yoktur. Sistem içerisinde 
tanımlanmaları yeterlidir. 
2. Ürünler adet bazlı satılmaktadır. 
3. Ürünler 10’ar adet olarak satın alınabilmektedir.
4. Ürünün geçerlilik 1 ay yani 30 gün ile sınırlıdır.
5. Ödeme işlemi için sisteme gerekli kayıtların yazılması yeterlidir. 
6. Ödeme işlemi senkron yapılmalıdır. 
7. İlanlar varsayılan olarak kaydedildiğinde IN_REVIEW statüsündedir. Asenkron 
olarak başka bir servis ACTIVE olarak değiştirmelidir. 
8. Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilir.

***İlanın statüleri;***
- ACTIVE
- PASSIVE
- IN_REVIEW
