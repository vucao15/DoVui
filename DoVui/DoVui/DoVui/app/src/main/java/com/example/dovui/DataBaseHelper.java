package com.example.dovui;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

class DataBaseHelper extends SQLiteOpenHelper {
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "datatestdovui.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;


    private String DATA_TABLE = "data";
    public String STT = "stt";
    public String CauHoi = "cauhoi";
    public String DapAn1 = "dapan1";
    public String DapAn2 = "dapan2";
    public String DapAn3 = "dapan3";
    public String DapAn4 = "dapan4";
    public String TraLoi = "traloi";


    // do đường dẫn ở phiên bản API > 17 thay đổi nên chúng ta cần kiểm tra nhé
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }


    public List<Question> searchQuestion(String text) {
        List<Question> questions = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM " + DATA_TABLE + " WHERE " + STT + " LIKE '" + text + "%'";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Question question = new Question();
                    question.stt = cursor.getInt(cursor.getColumnIndex(STT));
                    question.cauhoi =( cursor.getString(cursor.getColumnIndex(CauHoi)));
                    question.dapan1=(cursor.getString(cursor.getColumnIndex(DapAn1)));
                    question.dapan2=(cursor.getString(cursor.getColumnIndex(DapAn2)));
                    question.dapan3=(cursor.getString(cursor.getColumnIndex(DapAn3)));
                    question.dapan4=(cursor.getString(cursor.getColumnIndex(DapAn4)));
                    question.traloi=(cursor.getString(cursor.getColumnIndex(TraLoi)));


                    questions.add(question);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return questions;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}