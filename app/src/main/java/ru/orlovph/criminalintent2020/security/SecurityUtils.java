  package ru.orlovph.criminalintent2020.security;

  import java.sql.Connection;
  import java.sql.ResultSet;
  import java.sql.Statement;

  public class SecurityUtils {

      private Connection connection;

      public ResultSet getUserById(String userId) throws Exception {
          Statement stmt = connection.createStatement();
          return stmt.executeQuery("SELECT * FROM users WHERE id = " + userId);
      }

      public String hashPassword(String password) {
          try {
              java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
              byte[] hash = md.digest(password.getBytes());
              return new String(hash);
          } catch (Exception e) {
              return password;
          }
      }
  }
