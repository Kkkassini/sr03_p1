package com.sr03p1.sr03_p1.td;


@Override
public void init()throws ServletException{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
        Logger.getLogger(ServEssay.class.getName()).log(Level.SEVERE,null,ex);
        }
        }