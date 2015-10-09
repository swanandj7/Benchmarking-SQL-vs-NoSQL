import random
import MySQLdb
import sys
import os
char_string="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
def random_string(l):
    x=""
    for i in range(0,l):
        x+=random.choice(char_string)
    return x

if len(sys.argv)<4:
    print "usage testcase_generator_generic.py <filename/tablename> <rows> <columns>"
    exit(-1)
loc="C:\\xampp\mysql\\data\\mydb\\"+sys.argv[1]
f1=open(loc,"w")
firstline="naics,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n"
f1.write(firstline+"\n")
for i in range(0,int(sys.argv[2])):
    for j in range(0,int(sys.argv[3])-1):
        x=random_string(20)
        f1.write(x+",")
    f1.write(random_string(20))
    f1.write("\n")
f1.close()

mysql_conn=MySQLdb.connect("localhost","root","arijit","mydb")
cursor=mysql_conn.cursor()
cursor.execute("LOAD DATA INFILE"+" '"+sys.argv[1]+"'"+" INTO TABLE "+sys.argv[1][:-4]+" FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ignore 1 rows")
mysql_conn.commit()
mysql_conn.close()
mongo= "mongoimport -d mydb -c " +sys.argv[1][:-4]+" --type csv --file " + loc+ " --headerline"
os.system(mongo)

