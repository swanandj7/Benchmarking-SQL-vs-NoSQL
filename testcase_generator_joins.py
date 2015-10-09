import random
import pymongo
import sys
import MySQLdb
char_string="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
def random_string(l):
    x=""
    for i in range(0,l):
        x+=random.choice(char_string)
    return x
def main():
    
    #mysql part
    mysql_conn=MySQLdb.connect("localhost","root","arijit","mydb")
    cursor=mysql_conn.cursor()
    cursor.execute("delete from join1")
    cursor.execute("delete from join2")
    cursor.execute("LOAD DATA INFILE 'join1.txt' INTO TABLE join1 FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")
    cursor.execute("LOAD DATA INFILE 'join2.txt' INTO TABLE join2 FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")
    mysql_conn.commit()
    mysql_conn.close()

    try:
        conn=pymongo.MongoClient()
        print "Connected successfully!!!"
    except pymongo.errors.ConnectionFailure, e:
       print "Could not connect to MongoDB"
    db=conn.mydb
    coll=db.test_table4
    f1=open("C:\\xampp\mysql\\data\\mydb\\join1.txt","w")
    f2=open("C:\\xampp\mysql\\data\\mydb\\join2.txt","w")
    for i in range(0,int(sys.argv[1])):
        id_field=random_string(20)
        field1=random_string(20)
        field2=random_string(20)
        f1.write(id_field+ ","+field1+","+field2+"\n")
        worknotes=[]
        for j in range(0,10):
            worknote=random_string(50)
            if(i%69!=0):
                f2.write(id_field+","+worknote)
                f2.write("\n")
            worknotes.append(worknote)
        post={ "field1":field1,"field2":field2,"worknotes":[{ "worknote":worknotes[0]},{ "worknote":worknotes[1]},{ "worknote":worknotes[2]},{ "worknote":worknotes[3]},{ "worknote":worknotes[4]},{ "worknote":worknotes[5]},{ "worknote":worknotes[6]},{ "worknote":worknotes[7]},{ "worknote":worknotes[8]},{ "worknote":worknotes[9]}]}
        posts=db.posts
        posts.insert(post)
    conn.close
    f1.close()
    f2.close()
if __name__=='__main__':
    main()
