import random
import MySQLdb
char_string="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
def random_string(l):
    x=""
    for i in range(0,l):
        x+=random.choice(char_string)
    return x


f1=open("C:\\xampp\mysql\\data\\mydb\\"+sys.argv[1],"w")
for i in range(0,int(sys.argv[2])):
    for j in range(0,int(sys.argv[3])-1):
        x=random_string(20)
        f1.write(x+",")
    f1.write(random_string(20))
    f1.write("\n")
f1.close()

mysql_conn=MySQLdb.connect("localhost","root","arijit","mydb")
cursor=mysql_conn.cursor()
cursor.execute("LOAD DATA INFILE"+" '"+sys.argv[1]+"'"+" INTO TABLE "+sys.argv[1][:-4]+" FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")
mysql_conn.commit()
mysql_conn.close()

