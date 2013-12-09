package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFMeterBandExperimenter extends OFMeterBand  {
    public static int MINIMUM_LENGTH = 16;

    int  experimenter_id;

    public OFMeterBandExperimenter() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMeterBandType.valueOf((short)65535));
    }
    
    public OFMeterBandExperimenter(OFMeterBandExperimenter other) {
    	super(other);
		this.experimenter_id = other.experimenter_id;
    }

	public int getExperimenterId() {
		return this.experimenter_id;
	}
	
	public OFMeterBandExperimenter setExperimenterId(int experimenter_id) {
		this.experimenter_id = experimenter_id;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.experimenter_id = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.experimenter_id);
    }

    public String toString() {
        return super.toString() +  ":OFMeterBandExperimenter-"+":experimenter_id=" + U32.f(experimenter_id);
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
        		
		final int prime = 1987;
		int result = super.hashCode() * prime;
		result = prime * result + (int) experimenter_id;
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
        if (!(obj instanceof OFMeterBandExperimenter)) {
            return false;
        }
        OFMeterBandExperimenter other = (OFMeterBandExperimenter) obj;
		if ( experimenter_id != other.experimenter_id ) return false;
        return true;
    }
}
