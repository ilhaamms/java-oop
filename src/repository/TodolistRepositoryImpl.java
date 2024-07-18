package repository;

import entity.Todolist;

/*
    ini adalah class implementasi dari interface
    jadi bikin nama classnya yaitu TodolistRepositoryImpl
 */
public class TodolistRepositoryImpl implements TodolistRepository{

    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull(){
        boolean isFull = true;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){ // jika ada yang null maka data tidak penuh
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull(){
        if (isFull()){ // jika data penuh
            Todolist[] temp = data; // copy data model ke temp
            data = new Todolist[data.length * 2]; // resize length model menjadi 2x lipat

            // setelah di resize maka pindahkan kembali data yang di temp ke model
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(Todolist todo) {
        resizeIfFull(); // jika data penuh

        // jika data tidak penuh, maka masukan data todo ke model
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (number - 1 >= data.length){ // jika number sama dengan atau lebih besar dari panjang data
            return false;
        }else if(data[number-1] == null){ // jika data tidak ditemukan, maka return false
            return false;
        }else{
            /*
                index di array java itu kalau dihapus cuma di set null doang
                jadi indexnya tetep ada, misal panjang array 5 ketika dihapus(set null) maka panjang array tetap 5
             */
            for (int i = number-1; i < data.length; i++) {
                if (i == data.length-1){ // apabila indexnya sama dengan panjang dari array
                    // set data terakhir menjadi null, karena sudah di geser datanya ke index yang lain
                    // atau ke index yang dihapus user tadi, maka otomatis gaakan full datanya
                    // misal 10 data dengan panjang data 10 juga
                    // data no 5 dihapus, maka data hanya ada 9 saja
                    // nah karena digeser maka yang index terakhir di set null aja
                    data[i] = null;
                }else {
                    data[i] = data[i+1]; // isi index yang di set null dengan data index setelahnyaa
                }
            }

            return true;
        }
    }
}
