package com.example.cotlindersim
// Encapsulation yapabilmek için kullanıyoruz.
// Bir classın üye değişkenlerini private'da tutup bu değişkene erişilecek olan fonksiyonları publicte tutmanıza encapsulation diyoruz.
// Default visibility modifier Public'tir. Javada ise package - private'dır.

class Foo(){

    // toplam 4 tane visibility modifier'ımız var. public, protected, private ve internal


    // private olan değişkene class harici erişemezsiniz
    private val name = "Sertaç"

    // her yerden erişilebilir
    public val surname = "Ayhan"

    // o class içinde veya miras alan classlardan erişilebilir
    // Protected top level declaration yaparken kullanılamaz. Çünkü class için private tanımı yapılır. Top levelda class kavramı yoktur
    // javada ise top level declaration yoktur.
    protected val email = "srtc_ayhan@icloud.com"

    // modül bazında erişime açık özellikle kütüphane içinde kullanılır protected'ın modül versiyonu
    internal val age = 28

    fun printName(){
        print(name)
    }
    fun getName(): String{
        return name
    }}



open class Foo2(){  // Open keyword'ünü inheritance'da anlatacağız

    private val name = "Sertaç"

    public val surname = "Ayhan"

    internal val age = 28

    protected val email = "srtc_ayhan@icloud.com"

}

//---------------------------------------------Property VS Field--------------------------------------------------------
// Her şey publicken encapsulation nasıl sağlanıyor?

// Javada bir değişken yazdığımızda getter ve setterlarını sürekli yazıyoruz. Bu getter ve setterlar değişkenin property'leridir
// Kotlinde ise içeride bi değişken tanımladığımız anda aslında bir propertyleri ile tanımlamış oluyoruz.
// Encapsulation için özellikle private yapıyoruz. Javada default yazdığımız variable private olduğu için getter setter yazıyoruz.


class BankAccount {
    var balance = 1000_00
    private var dept = 1000_00
}

fun main(){
    val bankAccount = BankAccount()
    println(bankAccount.balance)
    bankAccount.balance = 500000_00
    println(bankAccount.balance)

}

// değişkenin kendisi private buna erişen get set methodları public.
// biz kotlinde public bir değişke tanımlasak bile bunun makine kodu private bir değişken getter ve setter methodları public.
// kotlinde field haline gerçekte erişmiyosunuz bile aslında encapsulation çekirdekten itibaren uygulanıyor kotlinde.
// javada encapsulationu delmek bir kere başına public yazmanız yeterli ama kotlinde
// kotlinde private tanımladığınız anda o değere hiçbir şekilde atama vs yaptırmadığı için delemiyorsunuz.
// private değişken tanımı yaptığınız an get set methodları yazılmadığı için bu işleri yaptırtmıyor