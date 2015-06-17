# CustomerManagement2
-Bu proje Spring MVC,JSF PrimeFaces ve MongoDB ile geliştirilmiştir. 
-Proje bağımlılıkları Maven ile yönetilmektedir.
-Proje Tomcat 7.0 sunucusu ile çalıştırılmalıdır.


Proje basit bir kullanıcı yönetim ekranı projesi. 
Sayfada sistemde kayıtlı olan kullanıcılar listelenir. Yeni kayit, guncelleme ve silme yapilabilir. Güncelle
butonuna basıldığında bir Modal Dialog çıkar ve içinde kullanıcı adı, soyadı, inputmask'lı telefonu ve
captcha gösterilir. Bu bilgiler istenirse güncellenebilir. Modal Dialog içindeki kaydet ve iptal butonları ile işlem yapılabilir.
Ad, soyad ve captcha alanı zorunlu alandır. Kullanıcıların listelendiği tabloda bir butona basılarak kullanıcılar silinebilir. 
Bu butona basıldığında confirmation dialog ile onay sorulması ardından kullanıcı db'den silinir. 
