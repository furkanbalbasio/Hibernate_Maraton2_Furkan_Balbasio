package org.example;

import org.example.controller.*;
import org.example.repository.UserRepository;
import org.example.repository.entity.User;

import java.util.Optional;
import java.util.Scanner;

import static org.example.utility.Constans.getBaseEntity;

public class Main {
    ComputerSpecController computerSpecController=new ComputerSpecController();
    UserController userController=new UserController();
    ComputerController computerController=new ComputerController();
    LikeController likeController=new LikeController();

    PostController postController=new PostController();

    public static void main(String[] args) {
        Main main=new Main();
        main.menu();
    }

    private void menu() {
        boolean control=true;
        do {
            menuIntro();
            System.out.print("Secim yapiniz : ");
            Integer secim = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (secim){
                case 1: registerUser(); break;
                case 2: loginUser();
                        mediaMenu(); break;
                case 0:control=false; break;
            }
        }while (control);
    }

    private void menuIntro(){
        System.out.println("*************************************");
        System.out.println("********* GİRİŞ  İŞLEMLERİ  *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1- Üye Ol");
        System.out.println("2- Giriş Yap");
        System.out.println("0- Cikis Yap");
    }
    private void registerUser() {
        System.out.println("*************************************");
        System.out.println("*********    YENI ÜYE       *********");
        System.out.println("*************************************");
        System.out.println();
        String username="",name="";
        System.out.print("Adınızı giriniz....");
        username=new Scanner(System.in).nextLine();
        System.out.print("username'inizi giriniz.....");
        name=new Scanner(System.in).nextLine();
        User user=User.builder()
                .username(username)
                .name(name)
                .photourl("")
                .baseEntity(getBaseEntity())
                .build();
        new UserRepository().save(user);
    }
    private void loginUser() {
        System.out.print("Lutfen username'inizi giriniz : ");
        String username = new Scanner(System.in).nextLine();
        Optional<User> user=userController.loginVerify(username);
        if(user.isPresent()){
            mediaMenu();
        }
        else {
            System.out.println("Bu kullanici bulunamamistir.");
        }
    }

    /**
     * o Bilgisayar Bileşeni oluştur – createSpec
     * o Bilgisayar oluştur – createComputer
     * o Yeni pos at – newPost
     * o Post a beğeni yap – likePost
     * o Tüm postları listele – postList
     * o Beğendiğim gönderiler – myLikePosts
     * o Bir kişiye ait postları listele – findPostsByUserId
     */
    private void mediaMenu() {
        Integer secim = 0;
        do {
            secim = mediaMenuIntro();
            switch(secim){
                case 1: createPcSpec(); break;

                case 2: createPc();break;

                case 3: newPost(); break;

                case 4: likePost(); break;

                case 5: listPosts(); break;

                case 6: listLikePosts(); break;

                case 7: findPostsByUserId();break;
            }
        }while (secim!=0);
    }

    private void findPostsByUserId() {
        userController.findAll().forEach(x->{
                    System.out.println(x.toString());
                }
                );
        System.out.print("Lutfen postlarını görmek istediğiniz postun sahibinin user id'sini giriniz : ");
        Long userid = new Scanner(System.in).nextLong();
        postController.findPostsByUserId(userid);
    }

    private void listLikePosts() {
        likeController.listLikePosts();
    }

    private void listPosts() {
        postController.listPosts();
    }

    private void likePost() {
        postController.listPosts();
        System.out.print("Lutfen likelamak istediğiniz postun id'sini giriniz : ");
        Long postid = new Scanner(System.in).nextLong();
        userController.findAll().forEach(x->{
            System.out.println(x.toString());
        });
        userController.findAll().forEach(x->{
                    System.out.println(x.toString());
                }
        );
        System.out.print("Lutfen likelamak istediğiniz postun sahibinin user id'sini giriniz : ");
        Long userid = new Scanner(System.in).nextLong();
        likeController.likePost(postid,userid);
    }

    private void newPost() {
        System.out.print("Lutfen oluşturmak istediğiniz postun commentini giriniz : ");
        String comment = new Scanner(System.in).nextLine();
        computerController.findAll().forEach(x->{
            System.out.println(x.toString());
        });
        System.out.print("Lutfen oluşturmak istediğiniz posttaki bilgisayarın id'sini giriniz : ");
        Long computerid = new Scanner(System.in).nextLong();
        userController.findAll().forEach(x->{
                    System.out.println(x.toString());
                }
        );
        System.out.print("Lutfen oluşturmak istediğiniz posttaki userin id'sini giriniz : ");
        Long userid = new Scanner(System.in).nextLong();
        postController.newPost(comment,computerid,userid);
    }

    private void createPc() {
        computerSpecController.findAll().forEach(x->{
            System.out.println(x.toString());
        });
        System.out.print("Lutfen oluşturmak istediğiniz bilgisayar özelliklerinin id'sini giriniz : ");
        Long specid = new Scanner(System.in).nextLong();
        computerController.createPc(specid);
    }

    private void createPcSpec() {
        System.out.print("Lutfen oluşturmak istediğiniz bilgisayarın RAM'ini giriniz : ");
        String ram = new Scanner(System.in).nextLine();
        System.out.print("Lutfen oluşturmak istediğiniz bilgisayarın ekran kartini giriniz : ");
        String ekranKarti = new Scanner(System.in).nextLine();
        System.out.print("Lutfen oluşturmak istediğiniz bilgisayarın işlemcisini giriniz : ");
        String islemci = new Scanner(System.in).nextLine();
        System.out.print("Lutfen oluşturmak istediğiniz bilgisayarın kapasitesini giriniz : ");
        String kapasite = new Scanner(System.in).nextLine();
        computerSpecController.createPcSpec(ram,ekranKarti,islemci,kapasite);
    }

    private Integer mediaMenuIntro() {
        System.out.println("*************************************");
        System.out.println("*********     İŞLEMLER      *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1- Bilgisayar Bileşeni oluştur");
        System.out.println("2- Bilgisayar oluştur");
        System.out.println("3- Yeni post at");
        System.out.println("4- Post'a beğeni yap");
        System.out.println("5- Tüm postları listele");
        System.out.println("6- Beğendiğim gönderileri listele");
        System.out.println("7- Bir kişiye ait postları listele");
        System.out.println("0- Cikis Yap");
        Integer secim=Integer.parseInt(new Scanner(System.in).nextLine());
        return secim;
    }

}