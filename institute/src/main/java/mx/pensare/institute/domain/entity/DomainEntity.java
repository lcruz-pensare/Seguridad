package mx.pensare.institute.domain.entity;

import java.io.Serializable;

/**
 * Created by dolphins on 1/19/18.
 */
public interface DomainEntity <ID extends Serializable>{
    ID getId();

    void setId(ID id);
}