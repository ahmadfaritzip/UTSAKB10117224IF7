package com.example.utsakb10117224if7.model.db;

public class AppDbHelper {
    //Nama Database
    public static final String DB_NAME = "daftarTeman.db";
    //Versi Database
    public static final int DB_VERSION = 1;
    //Nama Table
    public static final String TABLE = "biodata";

    //Colom Database
    public class Columns {
        public static final String C_NIM     = "nim";
        public static final String C_NAMA    = "nama";
        public static final String C_KELAS   = "kelas";
        public static final String C_TELEPON = "telepon";
        public static final String C_EMAIL   = "email";
        public static final String C_SOSMED  = "sosmed";
    }
}
