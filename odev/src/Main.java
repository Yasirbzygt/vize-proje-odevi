import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner ysr= new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("HOS GELDİNİZ LÜTFEN YAPMAK İSTEDİGİNİZ İSLEMİ GİRİNİZ:");
        System.out.println("------------------------------------------------------");
        System.out.println("ELİT ÜYE EKLEMEK İÇİN 1e");
        System.out.println("GENEL ÜYE EKLEMEK İÇİN 2ye");
        System.out.println("MAİL GÖNDERMEK İÇİN 3e BASINIZ:");
        System.out.println("------------------------------------------------------");

        int sayi;
        int secim;
        int a=1;
        String[]isimdizi= new String[100]; //girilecek kullanıcıların ismini tutmak icin
        String[]soyisimdizi= new String[100];//girilecek kullanıcıların soy ismini tutmak icin
        String[]maildizi= new String[100];//girilecek kullanıcıların mailini tutmak icin

        secim=ysr.nextInt();
        if (secim==1){

            System.out.println("KAC KULLANICI EKLEMEK İSTERSİNİZ ?");


            sayi=ysr.nextInt();
            for ( int j=0;j<sayi;j++) { //istenilen sayıda kullanıcı eklemek için for döngüsünü kullandık
                System.out.println("isim:");
                ysr.nextLine();
                String isim = ysr.nextLine();
                System.out.println("soy isim:");
                String soyisim = ysr.nextLine();
                System.out.println("mail:");
                String mail = ysr.nextLine();
                //yukarıda tek tek tüm verileri girdik (elit üyeler için)

                isimdizi[j] = isim;
                soyisimdizi[j] = soyisim;
                maildizi[j] = mail;
            }
            File file =new File("kullanıcılar.txt");
            //
            if (!file.exists()) {
                file.createNewFile();
            }


            FileWriter fWriter =new FileWriter(file, true);//dosayaya yazma işlemi belittiyor
            BufferedWriter bWriter=new BufferedWriter(fWriter);//dosyaya yazdırma işlemi yapar

            bWriter.write("---------------\n");
            bWriter.write("ELİT ÜYELER \n");
            bWriter.write("---------------\n");
            for (int i=0;i<sayi;i++) {

                bWriter.write((i+1)+". kullanıcı :");
                bWriter.write( isimdizi[i] + "    " + soyisimdizi[i] + "    " + maildizi[i]);//girilen kullanıcı sayısına göre eleman yazdırır

                bWriter.newLine();//BufferedWriter sınıfı bir karakter dosyasına veri yazmak için kullanılır

            }
            bWriter.close();
            FileReader fReader=new FileReader(file);//bir dosyayı okumak için kullanılan bir FileReader nesnesi oluşturur.
            String line;
            BufferedReader bReader = new BufferedReader(fReader);// verileri dosyadan okumak için kullanılan sınıflardır.


            while ((line=bReader.readLine()) !=null){
                System.out.println(line);
            }
            bReader.close(); //BufferedReader nesnesinin kapatılmasını sağlar.





        }

        else if (secim==2) {
            System.out.println("KAC KULLANICI EKLEMEK İSTERSİNİZ ?");


            sayi=ysr.nextInt();
            for ( int j=0;j<sayi;j++) {
                System.out.println("isim:");
                ysr.nextLine();
                String isim = ysr.nextLine();

                System.out.println("soy isim:");
                String soyisim = ysr.nextLine();
                System.out.println("mail:");
                String mail = ysr.nextLine();

                isimdizi[j] = isim;
                soyisimdizi[j] = soyisim;
                maildizi[j] = mail;
            }
            File file =new File("kullanıcılar.txt");
            if (file.exists()) {
                file.createNewFile();
            }

            FileWriter fWriter =new FileWriter(file, true);//bir dosyaya karakter yazma işlemini gerçekleştirmek için kullanılır
            BufferedWriter bWriter=new BufferedWriter(fWriter);

            bWriter.write("---------------\n");
            bWriter.write("GENEL ÜYELER \n");
            bWriter.write("---------------\n");
            for (int i=0;i<sayi;i++) {
                bWriter.write((i+1)+".  kullanıcı :");
                bWriter.write(isimdizi[i] + "    " + soyisimdizi[i] + "    " + maildizi[i]);

                bWriter.newLine();


            }
            bWriter.close();
            FileReader fReader=new FileReader(file);
            String line;
            BufferedReader bReader = new BufferedReader(fReader);
            while ((line=bReader.readLine()) !=null){
                System.out.println(line);
            }
            bReader.close();

        }

        else if (secim==3){ //gönderilecek mail icin seçim
            System.out.println("MAİL'İ GÖNDERMEK İSTEDİGİNİZ ÜYE TİPİNİ SECİNİZ:");
            System.out.println("------------------------------------------------------");

            System.out.println("ELİT ÜYELERE MAİL GÖNDERMEK İÇİN İÇİN 1e");
            System.out.println("GENEL ÜYELERE MAİL GÖNDERMEK İÇİN 2ye");
            System.out.println("TÜM ÜYELERE MAİL GÖNDERMEK İÇİN 3e BASINIZ");
            System.out.println("------------------------------------------------------");

            int secim2;
            secim2= ysr.nextInt();
            String secim3;

            if (secim2==1){
                System.out.println("LÜTFEN TÜM ELİT ÜYELERE MAİL ATMAK İCİN MAİL BİLGİNİZİ GİRİNİZ:"); // secim 3ün içi if
                secim3= ysr.nextLine();

            }
            else if (secim2==2) {
                System.out.println("LÜTFEN TÜM GENEL ÜYELERE MAİL ATMAK İCİN MAİL BİLGİNİZİ GİRİNİZ:");
                secim3= ysr.nextLine();

            }
            else if (secim2==3) {
                System.out.println("LÜTFEN TÜM ÜYELERE MAİL ATMAK İCİN MAİL BİLGİNİZİ GİRİNİZ:");
                secim3= ysr.nextLine();

            }
            else {
                System.out.println("lütfen gecerli bir sayi giriniz !!");//secim3 içi else
            }


        }

        else {
            System.out.println("lütfen gecerli bir sayi giriniz !!"); // son else geçersiz sayı için
        }





    }
}