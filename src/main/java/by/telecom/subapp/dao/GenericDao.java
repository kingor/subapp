/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ASUP8
 */
public interface GenericDao <T, PK extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    PK create(T newInstance);

    /** �?звлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);
    
    List<T> getAll(String sort, String orderType);
    
}
