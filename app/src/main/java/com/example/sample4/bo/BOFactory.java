package com.example.sample4.bo;


import com.example.sample4.bo.custom.impl.MainActivityBOImpl;

public class BOFactory {
        private static BOFactory boFactory;

        private BOFactory(){}

        public static BOFactory getBoFactory(){
                return (boFactory == null) ? boFactory=new BOFactory() : boFactory;
        }

        public enum BOTypes{
                MAIN_ACTIVITY_BO
        }

        public SuperBO getBO(BOTypes boTypes){
                switch (boTypes){
                        case MAIN_ACTIVITY_BO:
                                return new MainActivityBOImpl();

                        default:
                                return null;
                }
        }
}
