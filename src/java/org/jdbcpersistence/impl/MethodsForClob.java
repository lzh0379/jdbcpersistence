/**
 * JDBCPersistence framework for java
 *   Copyright (C) 2004-2014 Alex Rojkov
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *    You can contact me by email jdbcpersistence   a t   gmail    d o t    com
 * */

package org.jdbcpersistence.impl;

import java.lang.reflect.Method;
import java.sql.Clob;

class MethodsForClob
{
  public static Method getCharacterStream;
  public static Method setCharacterStream;

  static {
    initialize();
  }

  private static void initialize()
  {
    try {
      initializeReflectedMethods();
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  private static void initializeReflectedMethods()
    throws NoSuchMethodException
  {
    getCharacterStream = Clob.class.getMethod("getCharacterStream",
                                              new Class[0]);
    setCharacterStream = Clob.class.getMethod("setCharacterStream",
                                              new Class[]{long.class});
  }
}