package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFInstructionMeter extends OFInstruction  {
    public static int MINIMUM_LENGTH = 8;

    int  meter_id;

    public OFInstructionMeter() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFInstructionType.valueOf((short)6));
    }
    
    public OFInstructionMeter(OFInstructionMeter other) {
    	super(other);
		this.meter_id = other.meter_id;
    }

	public int getMeterId() {
		return this.meter_id;
	}
	
	public OFInstructionMeter setMeterId(int meter_id) {
		this.meter_id = meter_id;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.meter_id = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.meter_id);
    }

    public String toString() {
        return super.toString() +  ":OFInstructionMeter-"+":meter_id=" + U32.f(meter_id);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(short req) {
    	short l = (short)(computeLength() % req);
    	if ( l == 0 ) { return 0; }
    	return (short)( req - l );
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	return (short)(computeLength() - (short)MINIMUM_LENGTH + alignment((short)0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2089;
		int result = super.hashCode() * prime;
		result = prime * result + (int) meter_id;
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFInstructionMeter)) {
            return false;
        }
        OFInstructionMeter other = (OFInstructionMeter) obj;
		if ( meter_id != other.meter_id ) return false;
        return true;
    }
}
