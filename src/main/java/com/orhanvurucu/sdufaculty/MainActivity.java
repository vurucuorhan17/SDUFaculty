package com.orhanvurucu.sdufaculty;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap secilenResimler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> facultyName = new ArrayList<String>();
        facultyName.add("Mühendislik Fakültesi");
        facultyName.add("Orman Fakültesi");
        facultyName.add("Tıp Fakültesi");
        facultyName.add("Mimarlık Fakültesi");
        facultyName.add("Ziraat Fakültesi");
        facultyName.add("Fen ve Edebiyat Fakültesi");
        facultyName.add("Hukuk Fakültesi");

        Bitmap engineer = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sdu_muhendislik);
        Bitmap forest = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.orman);
        Bitmap medicine = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tip);
        Bitmap architecture = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.mimar);
        Bitmap agriculture = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ziraat);
        Bitmap fef = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fef);
        Bitmap justice = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hukuk);

        final ArrayList<Bitmap> facultyImages = new ArrayList<>();

        facultyImages.add(engineer);
        facultyImages.add(forest);
        facultyImages.add(medicine);
        facultyImages.add(architecture);
        facultyImages.add(agriculture);
        facultyImages.add(fef);
        facultyImages.add(justice);

        final ArrayList<String> facultyExplain = new ArrayList<String>();

        facultyExplain.add("Mühendislik Fakültesinde halen eğitim-öğretim veren 13 bölüm bulunmaktadır. \n" +
                "İnşaat, Makine, Jeoloji, Maden, Jeofizik, Tekstil ve Elektronik ve Haberleşme Mühendisliği Bölümlerinde ikinci öğretim mevcuttur. Mühendislik Fakültesi bünyesindeki tüm bölümler Üniversitenin Çünür'deki Batı Kampüsü içerisinde yer almaktadır.\n");

        facultyExplain.add("Süleyman Demirel Üniversitesi Orman Fakültesi,üniversitemizin kuruluşunda yer alan 12 fakülteden biridir.\n " +
                "1995-1996 Eğitim Öğretim yılında Orman Mühendisliği Bölümü açılarak lisans,yüksek lisans ve doktora eğitimi vermektedir.");

        facultyExplain.add("15 Nisan 1993'te açılan Tıp Fakültesi, 1993-1994 Eğitim-Öğretim Yılı'nda öğrenci almaya başlamıştır. Başlangıçta Sümerbanktan ve Sağlık Müdürlüğünden devir alınan binaların bir bölümünde hizmet veren Fakülte, 2002 yılında Doğu Kampüsü'nde tamamlanan binalarına taşınmıştır.");

        facultyExplain.add("Üniversitemizin 2016-2020 Stratejik Planı kapsamında öngörülen “GERÇEKÇİLİK, KALİTE, HUZUR, İLHAM VE SÜRDÜRÜLEBİLİRLİK” ana unsurlar kapsamında Fakültenin geleceğe yönelik KURUMSALLAŞMA, KALİTE VE VERİM, KAMU HİZMETİ VE KATKI SAĞLAMA amacıyla kurulmuştur."
        );

        facultyExplain.add("Süleyman Demirel Üniversitesi , Ziraat Fakültesi 1994 yılında kurulmuş olup, ilk olarak Bahçe Bitkileri ve Gıda Mühendisliği bölümlerine öğrenci alarak eğitim-öğretim faaliyetlerine başlamıştır.");

        facultyExplain.add("Fakültemiz, 03-07-1992 yılında kurulmuştur.Halen, 2014-2015 Eğitim-Öğretim yılı itibariyle 4.495 öğrencimiz bulunmaktadır. 2010 yılında yeni açılan Antropoloji Bölümü ve Mütercim-Tercümanlık Bölümü'yle birlikte 17 bölümün 12 bölümünde eğitim-öğretim yapılmaktadır.\n"
        );

        facultyExplain.add("Süleyman Demirel Üniversitesi Hukuk Fakültesi 12/8/2008 tarihinde kurulmuştur." +
        "Üniversitemizin yeni fakültelerinden biri olan Hukuk Fakültesi, genç ve dinamik eğitim kadrosuyla, Türk yükseköğretim sisteminin ve Üniversitemizin vizyonuna bağlı, evrensel hukuk değerlerinin savunucusu hukukçular yetiştirmek amacıyla 2009-2010'da kurulmuştur."
        );


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,facultyName);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("name",facultyName.get(position));
                intent.putExtra("explain",facultyExplain.get(position));

                secilenResimler = facultyImages.get(position);


                startActivity(intent);

            }
        });

    }
}
