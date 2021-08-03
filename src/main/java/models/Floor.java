package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class Floor {

    int floorId;
    Map<Integer,Slot> slotList;

}
