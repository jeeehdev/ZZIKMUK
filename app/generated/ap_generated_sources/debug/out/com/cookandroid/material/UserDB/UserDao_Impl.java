package com.cookandroid.material.UserDB;

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
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserData> __insertionAdapterOfUserData;

  private final EntityDeletionOrUpdateAdapter<UserData> __deletionAdapterOfUserData;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserData = new EntityInsertionAdapter<UserData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `table_user` (`id`,`mName`,`sOnOff`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserData value) {
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
    this.__deletionAdapterOfUserData = new EntityDeletionOrUpdateAdapter<UserData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `table_user` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserData value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE `table_user` SET mName = ? WHERE sOnOff = 1";
        return _query;
      }
    };
  }

  @Override
  public void insert(final UserData userData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserData.insert(userData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final UserData userData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUserData.handle(userData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final String sText) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (sText == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sText);
    }
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
  public List<UserData> getAll() {
    final String _sql = "SELECT * FROM `table_user`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMName = CursorUtil.getColumnIndexOrThrow(_cursor, "mName");
      final int _cursorIndexOfSOnOff = CursorUtil.getColumnIndexOrThrow(_cursor, "sOnOff");
      final List<UserData> _result = new ArrayList<UserData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserData _item;
        _item = new UserData();
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
