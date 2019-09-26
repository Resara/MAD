package com.example.enigma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperProduct extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Enigma.db";

    public static final String PRODUCT_TABLE_NAME = "product_table";
    public static final String Col_Id = "ID";
    public static final String Col_name = "Name";
    public static final String Col_title = "Title";
    public static final String Col_rating = "Rating";
    public static final String Col_price = "Price";

    public static final String EMPLOYEE_TABLE_NAME = "employee_table";
    public static final String COL_eID = "ID";
    public static final String COL_eNAME = "Name";
    public static final String COL_eCONTACT = "Contact";
    public static final String COL_eEMAIL = "Email";
    public static final String COL_ePASSWORD = "Password";

    public static final String DELIVERY_TABLE_NAME = "deliveries_table";
    public static final String Col_ProID = "ID";
    public static final String Col_ProName = "Product";
    public static final String Col_cusName = "Name";
    public static final String Col_address = "Address";
    public static final String Col_Phone = "Phone";
    public static final String Col_qty = "Quantity";
    public static final String Col_ProPrice = "Price";

    public static final String PURCHASE_TABLE_NAME = "Cart_table";
    public static final String COL_1 = "cartID";
    public static final String COL_2 = "itemName";
    public static final String COL_3 = "cname";
    public static final String COL_4 = "address";
    public static final String COL_5 = "price";
    public static final String COL_6 = "qty";


    public DatabaseHelperProduct(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EMPLOYEE_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Contact TEXT, Email TEXT, Password TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + DELIVERY_TABLE_NAME + "(ID INTEGER PRIMARY KEY , Product TEXT, Name TEXT,Address TEXT,Phone TEXT, Quantity INTEGER, Price DOUBLE )");
        sqLiteDatabase.execSQL("CREATE TABLE " + PRODUCT_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Title text,Rating DOUBLE,Price DOUBLE )");
        sqLiteDatabase.execSQL(" CREATE TABLE " + PURCHASE_TABLE_NAME + " (cartID INTEGER PRIMARY KEY AUTOINCREMENT,itemName TEXT,cname TEXT,address TEXT,price DOUBLE,qty INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DELIVERY_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PURCHASE_TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    //samitha insert
    public boolean addInfo(Product obj) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelperProduct.Col_name, obj.getTitle());
        values.put(DatabaseHelperProduct.Col_title, obj.getShortdesc());
        values.put(DatabaseHelperProduct.Col_rating, obj.getRating());
        values.put(DatabaseHelperProduct.Col_price, obj.getPrice());

        long result = db.insert(PRODUCT_TABLE_NAME, null, values);

        if (result > 0) {
            return true;

        } else {
            return false;
        }

    }


    //Umaya - Inserting in database

    public boolean addEmployee(Employee employee){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_eNAME, employee.getName());
        contentValues.put(COL_eCONTACT, employee.getContact());
        contentValues.put(COL_eEMAIL, employee.getEmail());
        contentValues.put(COL_ePASSWORD, employee.getPassword());

        long ins = sqLiteDatabase.insert(EMPLOYEE_TABLE_NAME, null, contentValues);

        if (ins > 0)
            return true;
        else
            return false;
    }

    //Umaya - checking if email exists
    public boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from employee_table where email=?", new String[]{email});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    //Umaya - checking the email & password from database
    public boolean emailPassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from employee_table where email=? and password=?", new String[]{email,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    //uvini insert
    public boolean addDelivery(Delivery delivery) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        /*values.put(Col_ProID,proID);
        values.put(Col_ProName,proName);
        values.put(Col_cusName,cusName);
        values.put(Col_address,address);
        values.put(Col_Phone,phone);
        values.put(Col_qty,qty);
        values.put(Col_ProPrice,price);*/

        values.put(DatabaseHelperProduct.Col_ProID, delivery.getProID());
        values.put(DatabaseHelperProduct.Col_ProName, delivery.getProName());
        values.put(DatabaseHelperProduct.Col_cusName, delivery.getCustomerName());
        values.put(DatabaseHelperProduct.Col_address, delivery.getAddress());
        values.put(DatabaseHelperProduct.Col_Phone, delivery.getPhone());
        values.put(DatabaseHelperProduct.Col_qty, delivery.getQuantity());
        values.put(DatabaseHelperProduct.Col_ProPrice, delivery.getPrice());

        long result = db.insert(DELIVERY_TABLE_NAME, null, values);

        if (result > 0) {
            return true;

        } else {
            return false;

        }


    }

    //RESARA INSERT

    public boolean insertPurchase(String itemName,String cname,String address,String price,String qty){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,itemName);
        contentValues.put(COL_3,cname);
        contentValues.put(COL_4,address);
        contentValues.put(COL_5,price);
        contentValues.put(COL_6,qty);

        long result = db.insert(PURCHASE_TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    //SAMITHA
    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + PRODUCT_TABLE_NAME,null);
        return res;
    }

    //UMAYA
    public Cursor getAllEmployee(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + EMPLOYEE_TABLE_NAME,null);
        return res;
    }


    //UVINI
    public Cursor getAllDelivery(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DELIVERY_TABLE_NAME,null);
        return res;
    }

    //RESARA
    public Cursor getAllPurchases(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + PURCHASE_TABLE_NAME,null);
        return res;
    }

    //samitha update
    public boolean updateData(String id, String name, String des, String rate, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelperProduct.Col_Id,id);
        values.put(DatabaseHelperProduct.Col_name,name);
        values.put(DatabaseHelperProduct.Col_title,des);
        values.put(DatabaseHelperProduct.Col_rating,rate);
        values.put(DatabaseHelperProduct.Col_price,price);

        db.update(PRODUCT_TABLE_NAME,values,"ID = ?",new String[]{ id });

        return true;
    }

    //umaya update
    public boolean updateEmployee(String id, String name, String contact, String email, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelperProduct.COL_eID,id);
        values.put(DatabaseHelperProduct.COL_eNAME,name);
        values.put(DatabaseHelperProduct.COL_eCONTACT,contact);
        values.put(DatabaseHelperProduct.COL_eEMAIL,email);
        values.put(DatabaseHelperProduct.COL_ePASSWORD,password);

        db.update(EMPLOYEE_TABLE_NAME,values,"ID = ?",new String[]{ id });

        return true;
    }

    //uvini update
    public boolean updateDelivery(String proID, String ProName, String cusName, String address, String phone, String qty, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelperProduct.Col_ProID,proID);
        values.put(DatabaseHelperProduct.Col_ProName,ProName);
        values.put(DatabaseHelperProduct.Col_cusName,cusName);
        values.put(DatabaseHelperProduct.Col_address,address);
        values.put(DatabaseHelperProduct.Col_Phone,phone);
        values.put(DatabaseHelperProduct.Col_qty,qty);
        values.put(DatabaseHelperProduct.Col_price,price);

        db.update(DELIVERY_TABLE_NAME,values,"ID = ?", new String[] {proID});

        return true;
    }

    //RESARA UPDATE

    public boolean updatePurchase(String pID,String itemName,String cname,String address,String price,String qty){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,pID);
        contentValues.put(COL_2,itemName);
        contentValues.put(COL_3,cname);
        contentValues.put(COL_4,address);
        contentValues.put(COL_5,price);
        contentValues.put(COL_6,qty);

        db.update(PURCHASE_TABLE_NAME,contentValues,"cartID = ?",new String[] {pID});

        return true;
    }

    //samitha delete
    public int deleteData(String id){

        SQLiteDatabase db = getWritableDatabase();
        return db.delete(PRODUCT_TABLE_NAME,"ID = ?",new String[]{id});

    }

    //umaya delete
    public int deleteEmployee(String id){

        SQLiteDatabase db = getWritableDatabase();
        return db.delete(EMPLOYEE_TABLE_NAME,"ID = ?",new String[]{id});

    }

    //uvini delete
    public int deleteDelivery(String  proID){
        SQLiteDatabase db = getWritableDatabase();
        return  db.delete(DELIVERY_TABLE_NAME,"ID = ?",new String[] {proID});
    }

    //resara delete

    public int deleteItem(String  pID){
        SQLiteDatabase db = getWritableDatabase();
        return  db.delete(PURCHASE_TABLE_NAME,"cartID = ?",new String[] {pID});
    }

}
