package com.service.yis.product;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class ProductDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public int Fruitstart = 0;
    public int Vegetablestart = 0;
    public int Cropstart = 0;
    int amount = 4;

    public List listFruit(ProductVO productVO) {
        List<ProductVO> fruitList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * " + "from product_test " + "where category = '" + "과일" + "'" + "limit " + Fruitstart + "," + amount);

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String date = rs.getString("D_date");
                int price = rs.getInt("price");

                ProductVO vo = new ProductVO();
                vo.setProduct_id(product_id);
                vo.setProduct_name(product_name);
                vo.setDate(date);
                vo.setPrice(price);

                fruitList.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        Fruitstart += 4;
        return fruitList;
    }
    
    public List listVegetable(ProductVO productVO) {
        List<ProductVO> vegetableList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * " + "from product_test " + "where category = '" + "채소" + "'" + "limit " + Vegetablestart + "," + amount);

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String date = rs.getString("D_date");
                int price = rs.getInt("price");

                ProductVO vo = new ProductVO();
                vo.setProduct_id(product_id);
                vo.setProduct_name(product_name);
                vo.setDate(date);
                vo.setPrice(price);

                vegetableList.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        Vegetablestart += 4;
        return vegetableList;
    }
    
    public List listCrop(ProductVO productVO) {
        List<ProductVO> cropList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * " + "from product_test " + "where category = '" + "작물" + "'" + "limit " + Cropstart + "," + amount);

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String date = rs.getString("D_date");
                int price = rs.getInt("price");

                ProductVO vo = new ProductVO();
                vo.setProduct_id(product_id);
                vo.setProduct_name(product_name);
                vo.setDate(date);
                vo.setPrice(price);

                cropList.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        Cropstart += 4;
        return cropList;
    }

    public List listKeyword(ProductVO productVO, Criteria cri) {
        List<ProductVO> keywordList = new ArrayList<>();
        String keyword = productVO.getProduct_name();
        int pageNum = cri.pageNum - 1;
        int amount = cri.amount;

        try {
            int start = pageNum * 12;

            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from product_test where product_name like '%" + keyword + "%'" + "limit " + start + "," + amount);

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String date = rs.getString("D_date");
                int price = rs.getInt("price");

                ProductVO vo = new ProductVO();
                vo.setProduct_id(product_id);
                vo.setProduct_name(product_name);
                vo.setDate(date);
                vo.setPrice(price);

                keywordList.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return keywordList;
    }
    
    public List listDetail(ProductVO productVO, Criteria cri) throws ParseException {
        List<ProductVO> detailList = new ArrayList<>();
        String category = productVO.getProduct_name();
        String dates = productVO.getDate();
        int prices = productVO.getPrice();

        int pageNum = cri.pageNum - 1;
        int amount = cri.amount;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRes = formatter.parse(dates);
        java.sql.Date sqlDate = new java.sql.Date(dateRes.getTime());

        try {
            int start = pageNum * 12;
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * " +
                    "from product_test " +
                    "where product_name " +
                    "like '%" + category + "%'" +
                    "and D_date = '" + sqlDate + "'" +
                    "and price <= '" + prices + "'" +
                    "limit " + start + "," + amount);

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String date = rs.getString("D_date");
                int price = rs.getInt("price");

                ProductVO vo = new ProductVO();
                vo.setProduct_id(product_id);
                vo.setProduct_name(product_name);
                vo.setDate(date);
                vo.setPrice(price);

                detailList.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return detailList;
    }
    
    public int getKeywordTotal(ProductVO productVO){
        int total = 0;
        String keyword = productVO.getProduct_name();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) from product_test where product_name like '%" + keyword + "%'");

            if(rs.next())
                total = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return total;
    }
    
    public int getDetailTotal(ProductVO productVO) throws ParseException {
        int total = 0;
        String product_name = productVO.getProduct_name();
        String date = productVO.getDate();
        int prices = productVO.getPrice();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRes = formatter.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(dateRes.getTime());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcDriver = "jdbc:mysql://20.214.186.164:3306/yis?" +
                    "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String dbUser = "yis";
            String dbPass = "1234";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) " +
                    "from product_test " +
                    "where product_name " +
                    "like '%" + product_name + "%'" +
                    "and D_date = '" + sqlDate + "'" +
                    "and price <= '" + prices + "'");

            if(rs.next())
                total = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return total;
    }
}