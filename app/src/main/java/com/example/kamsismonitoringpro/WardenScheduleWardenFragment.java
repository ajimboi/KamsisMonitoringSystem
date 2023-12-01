package com.example.kamsismonitoringpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WardenScheduleWardenFragment extends Fragment {

    private CalendarView calendarView;
    private ListView scheduleListView;
    private ArrayAdapter<String> scheduleAdapter;
    private Map<String, List<String>> scheduleData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_warden_schedule_warden, container, false);

        calendarView = rootView.findViewById(R.id.calendarView);
        scheduleListView = rootView.findViewById(R.id.scheduleListView);

        // Initialize schedule data (replace with your actual data)
        scheduleData = new HashMap<>();
        // Add your schedule data here...
        scheduleData.put("2023-10-01", new ArrayList<String>() {{
            add("D AHAD");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-10-02", new ArrayList<String>() {{
            add("E ISNIN");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-10-03", new ArrayList<String>() {{
            add("F SELASA");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-10-04", new ArrayList<String>() {{
            add("G RABU");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-10-05", new ArrayList<String>() {{
            add("H KHAMIS");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-10-06", new ArrayList<String>() {{
            add("A JUMAAT");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-10-07", new ArrayList<String>() {{
            add("B SABTU");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-10-08", new ArrayList<String>() {{
            add("C AHAD");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-10-09", new ArrayList<String>() {{
            add("ISNIN");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-10-10", new ArrayList<String>() {{
            add("SELASA");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-10-11", new ArrayList<String>() {{
            add("RABU");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-10-12", new ArrayList<String>() {{
            add("KHAMIS");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-10-13", new ArrayList<String>() {{
            add("JUMAAT");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-10-14", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-15", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-16", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-17", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-18", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-19", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-20", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-21", new ArrayList<String>() {{
            add("CUTI");
        }});
        scheduleData.put("2023-10-22", new ArrayList<String>() {{
            add("AHAD");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");

        }});
        scheduleData.put("2023-10-23", new ArrayList<String>() {{
            add("ISNIN");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-10-24", new ArrayList<String>() {{
            add("SELASA");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-10-25", new ArrayList<String>() {{
            add("RABU");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-10-26", new ArrayList<String>() {{
            add("KHAMIS");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-10-27", new ArrayList<String>() {{
            add("JUMAAT");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-10-28", new ArrayList<String>() {{
            add("SABTU");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-10-29", new ArrayList<String>() {{
            add("AHAD");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-10-30", new ArrayList<String>() {{
            add("ISNIN");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-10-31", new ArrayList<String>() {{
            add("SELASA");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});


        // Bulan November 2023
        scheduleData.put("2023-11-01", new ArrayList<String>() {{
            add("RABU");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-11-02", new ArrayList<String>() {{
            add("KHAMIS");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-11-03", new ArrayList<String>() {{
            add("JUMAAT");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-11-04", new ArrayList<String>() {{
            add("SABTU");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-11-05", new ArrayList<String>() {{
            add("AHAD");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-11-06", new ArrayList<String>() {{
            add("ISNIN");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-11-07", new ArrayList<String>() {{
            add("SELASA");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-11-08", new ArrayList<String>() {{
            add("RABU");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-11-09", new ArrayList<String>() {{
            add("KHAMIS");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-11-10", new ArrayList<String>() {{
            add("JUMAAT");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-11-11", new ArrayList<String>() {{
            add("SABTU");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-11-12", new ArrayList<String>() {{
            add("AHAD");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-11-13", new ArrayList<String>() {{
            add("ISNIN");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-11-14", new ArrayList<String>() {{
            add("SELASA");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-11-15", new ArrayList<String>() {{
            add("RABU");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-11-16", new ArrayList<String>() {{
            add("KHAMIS");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-11-17", new ArrayList<String>() {{
            add("JUMAAT");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");

        }});
        scheduleData.put("2023-11-18", new ArrayList<String>() {{
            add("SABTU");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-11-19", new ArrayList<String>() {{
            add("AHAD");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-11-20", new ArrayList<String>() {{
            add("ISNIN");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-11-21", new ArrayList<String>() {{
            add("SELASA");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-11-22", new ArrayList<String>() {{
            add("RABU");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");

        }});
        scheduleData.put("2023-11-23", new ArrayList<String>() {{
            add("KHAMIS");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");

        }});
        scheduleData.put("2023-11-24", new ArrayList<String>() {{
            add("JUMAAT");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-11-25", new ArrayList<String>() {{
            add("SABTU");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");

        }});
        scheduleData.put("2023-11-26", new ArrayList<String>() {{
            add("AHAD");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-11-27", new ArrayList<String>() {{
            add("ISNIN");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");

        }});
        scheduleData.put("2023-11-28", new ArrayList<String>() {{
            add("SELASA");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");

        }});
        scheduleData.put("2023-11-29", new ArrayList<String>() {{
            add("RABU");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-11-30", new ArrayList<String>() {{
            add("KHAMIS");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});

        // Bulan Desember 2023
        scheduleData.put("2023-12-01", new ArrayList<String>() {{
            add("JUMAAT");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});

        scheduleData.put("2023-12-02", new ArrayList<String>() {{
            add("SABTU");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-12-03", new ArrayList<String>() {{
            add("AHAD");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-12-04", new ArrayList<String>() {{
            add("ISNIN");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-12-05", new ArrayList<String>() {{
            add("SELASA");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-12-06", new ArrayList<String>() {{
            add("RABU");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-12-07", new ArrayList<String>() {{
            add("KHAMIS");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-12-08", new ArrayList<String>() {{
            add("JUMAAT");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-12-09", new ArrayList<String>() {{
            add("SABTU");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-12-10", new ArrayList<String>() {{
            add("AHAD");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2023-12-11", new ArrayList<String>() {{
            add("ISNIN");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-12-12", new ArrayList<String>() {{
            add("SELASA");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-12-13", new ArrayList<String>() {{
            add("RABU");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-12-14", new ArrayList<String>() {{
            add("KHAMIS");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-12-15", new ArrayList<String>() {{
            add("JUMAAT");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});
        scheduleData.put("2023-12-16", new ArrayList<String>() {{
            add("SABTU");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});
        scheduleData.put("2023-12-17", new ArrayList<String>() {{
            add("AHAD");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-12-18", new ArrayList<String>() {{
            add("ISNIN");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");

        }});
        scheduleData.put("2023-12-19", new ArrayList<String>() {{
            add("SELASA");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-12-20", new ArrayList<String>() {{
            add("RABU");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2023-12-21", new ArrayList<String>() {{
            add("KHAMIS");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");
        }});
        scheduleData.put("2023-12-22", new ArrayList<String>() {{
            add("JUMAAT");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-12-23", new ArrayList<String>() {{
            add("SABTU");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");

        }});
        scheduleData.put("2023-12-24", new ArrayList<String>() {{
            add("AHAD");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");

        }});
        scheduleData.put("2023-12-25", new ArrayList<String>() {{
            add("ISNIN");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2023-12-26", new ArrayList<String>() {{
            add("SELASA");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");

        }});
        scheduleData.put("2023-12-27", new ArrayList<String>() {{
            add("RABU");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2023-12-28", new ArrayList<String>() {{
            add("KHAMIS");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");

        }});
        scheduleData.put("2023-12-29", new ArrayList<String>() {{
            add("JUMAAT");
            add("AZAWANI BINTI ZULKAFALI");
            add("NORLIZA BINTI MOHD. NOOR");
            add("MUHAMMAD ZAID BIN HAMID");
            add("AZRUL JAZNI BIN AZIS");

        }});
        scheduleData.put("2023-12-30", new ArrayList<String>() {{
            add("SABTU");
            add("ZAHARUDIN BIN MOHD NOR");
            add("MUHAMMAD REDZUAN BIN CHE NOORDIN");
            add("MOHD. FAIZULLAH BIN ABD. KARIM");
            add("NOR AZIDA BINTI MANSOR");
        }});
        scheduleData.put("2023-12-31", new ArrayList<String>() {{
            add("AHAD");
            add("SAIFUL BAHARIN BIN HAIRUDDIN");
            add("HUZAIFAH BIN ABDUL RAZAB @ GHAZAL");
            add("ISMUL AZAM BIN ISMAIL");
            add("SURAIYA AZWA BINTI ABDULLAH");
        }});

        // Bulan Januari 2024
        scheduleData.put("2024-01-01", new ArrayList<String>() {{
            add("ISNIN");
            add("NORHASWIRA BIN BUYUNG GADANG");
            add("AZRUL JUNAIDI BIN ABD AZIZ");
            add("NORASHIKIN BINTI ZAINAL ABIDIN");
            add("MUHAMMAD AZMAN BIN MOKTER");
        }});

        scheduleData.put("2024-01-02", new ArrayList<String>() {{
            add("SELASA");
            add("MOHD ROSDI BIN RIPIN");
            add("MOHD AFANDI BIN ABDUL HAMID");
            add("PARTHIBAN A/L MOGANA SONDARAM");
            add("NOR HASLINDA BINTI YUSUFF");
        }});
        scheduleData.put("2024-01-03", new ArrayList<String>() {{
            add("RABU");
            add("SHAHRUL NAHAR BIN OMAR KAMAL");
            add("ANORRASYIDI BIN ANWAR");
            add("KHAIRUL AKMAL BIN NUSI");
            add("NORHASLINA BINTI SULAIMAN");
        }});
        scheduleData.put("2024-01-04", new ArrayList<String>() {{
            add("KHAMIS");
            add("MOHD NAZRIN BIN NAHAR");
            add("AHMAD FITRI HASYIMIE BIN HASHIM");
            add("NURULHUDA BINTI MOHAMAD NASRI");
            add("MOHD YUSRI BIN MD YUSOFF");
        }});
        scheduleData.put("2024-01-05", new ArrayList<String>() {{
            add("JUMAAT");
            add("ADIJAH BINTI AYOB");
            add("SHAHRIL BIN JALIL");
            add("MARZUKI BIN MOHAMMAD");
            add("MOHAMMAD FAIZ BIN MOHAMAD NASRI");
        }});
        scheduleData.put("2024-01-06", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-07", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-08", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-09", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-10", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-11", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-12", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-13", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-14", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-15", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-16", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-17", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-18", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-19", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-20", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-21", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-22", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-23", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-24", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-25", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-26", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-27", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-28", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-29", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-30", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});
        scheduleData.put("2024-01-31", new ArrayList<String>() {{
            add("CUTI SEM SESI 1 2023/2024");
        }});

        // Initialize the schedule adapter
        scheduleAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        scheduleListView.setAdapter(scheduleAdapter);

        // Set a listener for calendar date selection
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth); // Month is 0-based
                updateSchedule(selectedDate);
            }
        });

        return rootView;
    }

    private void updateSchedule(String selectedDate) {
        if (scheduleData.containsKey(selectedDate)) {
            List<String> events = scheduleData.get(selectedDate);
            scheduleAdapter.clear();
            scheduleAdapter.addAll(events);
        } else {
            scheduleAdapter.clear();
            Toast.makeText(requireContext(), "No events for selected date", Toast.LENGTH_SHORT).show();
        }
    }
}
