import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.*;


public class TestDemo {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        Connection connection =
                DriverManager.getConnection(url,username,password);

        //执行SQL 语句
        String sql = "select * from user";

        Statement statement = connection.createStatement();

        //结果集
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        //json Gson
        if(resultSet.next()) {
            /*System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId_number(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println(user);

        connection.close();
        statement.close();
        resultSet.close();
    }

    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        Connection connection =
                DriverManager.getConnection(url,username,password);

        //执行SQL 语句
        String uname = "bit";
        String upass = "123";
        String sql = "select * from user where name = ' " +uname+ " ' and password = ' " + upass + " ' ";

        Statement statement = connection.createStatement();

        //结果集
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        //json Gson
        if(resultSet.next()) {
            /*System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId_number(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println(user);
    }
//查询
    public static void main3(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        //Connection connection = DriverManager.getConnection(url,username,password);

        DataSource dataSource = new MysqlDataSource();//获取数据源
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);


        Connection connection = dataSource.getConnection();





        //执行SQL 语句
        String uname = "bit";
        String upass = "123";
        //String sql = "select * from user where name = ' " +uname+ " ' and password = ' " + upass + " ' ";
        String sql = "select * from user where name = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,uname);
        preparedStatement.setString(2,upass);


        //Statement statement = connection.createStatement();

        //结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        //json Gson
        if(resultSet.next()) {
            /*System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId_number(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println(user);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    //插入
    public static void main4(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        //Connection connection = DriverManager.getConnection(url,username,password);

        DataSource dataSource = new MysqlDataSource();//获取数据源
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);


        Connection connection = dataSource.getConnection();





        //执行SQL 语句
        String uname = "gaobo2";
        String upass = "000";
        //String sql = "select * from user where name = ' " +uname+ " ' and password = ' " + upass + " ' ";
        String sql = "insert into user (id_number,name,password) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,uname);
        preparedStatement.setString(3,upass);
        int ret = preparedStatement.executeUpdate();
        if(ret != 0) {
            System.out.println("插入成功！");
        }

        preparedStatement.close();
        connection.close();
    }
    //更新
    public static void main5(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        //Connection connection = DriverManager.getConnection(url,username,password);

        DataSource dataSource = new MysqlDataSource();//获取数据源
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);


        Connection connection = dataSource.getConnection();





        //执行SQL 语句
        String uname = "gaobo2";
        String upass = "000";
        //String sql = "select * from user where name = ' " +uname+ " ' and password = ' " + upass + " ' ";


        String sql = "update user set name = ? where id_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,uname);
        preparedStatement.setInt(2,2);
        int ret = preparedStatement.executeUpdate();
        if(ret != 0) {
            System.out.println("更新成功！");
        }

        preparedStatement.close();
        connection.close();
    }

    //删除
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";//数据库名称
        String password = "111111";//数据库密码

        //API接口： Connection Statement ResultSet
        //Connection connection = DriverManager.getConnection(url,username,password);

        DataSource dataSource = new MysqlDataSource();//获取数据源
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        Connection connection = dataSource.getConnection();

        //执行SQL 语句
        String uname = "gaobo2";
        String upass = "000";
        //String sql = "select * from user where name = ' " +uname+ " ' and password = ' " + upass + " ' ";


        String sql = "delete from user where id_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        int ret = preparedStatement.executeUpdate();
        if(ret != 0) {
            System.out.println("删除成功！");
        }

        preparedStatement.close();
        connection.close();
    }
}
