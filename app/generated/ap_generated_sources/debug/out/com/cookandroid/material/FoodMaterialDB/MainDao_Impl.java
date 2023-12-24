package com.cookandroid.material.FoodMaterialDB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MainDao_Impl implements MainDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MainData> __insertionAdapterOfMainData;

  private final EntityDeletionOrUpdateAdapter<MainData> __deletionAdapterOfMainData;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  private final SharedSQLiteStatement __preparedStmtOfSwitch_update;

  public MainDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMainData = new EntityInsertionAdapter<MainData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Food Material` (`id`,`mName`,`sOnOff`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MainData value) {
        stmt.bindLong(1, value.id);
        if (value.mName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mName);
        }
        final int _tmp;
        _tmp = value.sOnOff ? 1 : 0;
        stmt.bindLong(3, _tmp);
      }
    };
    this.__deletionAdapterOfMainData = new EntityDeletionOrUpdateAdapter<MainData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Food Material` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MainData value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE `Food Material` SET mName = ? WHERE ID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSwitch_update = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE `Food Material` SET sOnOff = ? WHERE ID = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final MainData mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMainData.insert(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MainData mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMainData.handle(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void reset(final List<MainData> mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMainData.handleMultiple(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final int sID, final String sText) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (sText == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sText);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, sID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public void switch_update(final boolean onOff, final int sID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSwitch_update.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = onOff ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, sID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSwitch_update.release(_stmt);
    }
  }

  @Override
  public List<MainData> getAll() {
    final String _sql = "SELECT * FROM `Food Material`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMName = CursorUtil.getColumnIndexOrThrow(_cursor, "mName");
      final int _cursorIndexOfSOnOff = CursorUtil.getColumnIndexOrThrow(_cursor, "sOnOff");
      final List<MainData> _result = new ArrayList<MainData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MainData _item;
        _item = new MainData();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.mName = _cursor.getString(_cursorIndexOfMName);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSOnOff);
        _item.sOnOff = _tmp != 0;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MainData> getOn() {
    final String _sql = "SELECT * FROM `Food Material` WHERE sOnOff = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMName = CursorUtil.getColumnIndexOrThrow(_cursor, "mName");
      final int _cursorIndexOfSOnOff = CursorUtil.getColumnIndexOrThrow(_cursor, "sOnOff");
      final List<MainData> _result = new ArrayList<MainData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MainData _item;
        _item = new MainData();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.mName = _cursor.getString(_cursorIndexOfMName);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSOnOff);
        _item.sOnOff = _tmp != 0;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
