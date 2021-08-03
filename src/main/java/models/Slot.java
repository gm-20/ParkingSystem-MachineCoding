package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Slot {

    private int slotId;
    private boolean isEmpty;

}
