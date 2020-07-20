package org.yzh.web.jt808.dto.basics;

import org.yzh.framework.annotation.Property;
import org.yzh.framework.enums.DataType;
import org.yzh.framework.message.AbstractBody;
import org.yzh.web.jt808.common.ParameterUtils;

import java.nio.charset.Charset;

/**
 * 终端参数项
 */
public class TerminalParameter extends AbstractBody {

    private Integer id;
    private Integer length;
    private byte[] bytesValue;

    public TerminalParameter() {
    }

    public TerminalParameter(Integer id, byte[] bytes) {
        this.id = id;
        this.length = bytes.length;
        this.bytesValue = bytes;
    }

    public TerminalParameter(Integer id, int value) {
        this.id = id;
        byte[] bytes = ParameterUtils.toBytes(id, value);
        this.length = bytes.length;
        this.bytesValue = bytes;
    }


    public TerminalParameter(Integer id, String value) {
        this.id = id;
        this.bytesValue = value.getBytes(Charset.forName("GBK"));
        this.length = bytesValue.length;
    }

    @Property(index = 0, type = DataType.DWORD, desc = "参数ID", version = {0, 1})
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "参数长度", version = {0, 1})
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Property(index = 3, type = DataType.BYTES, lengthName = "length", desc = "参数值", version = {0, 1})
    public byte[] getBytesValue() {
        return bytesValue;
    }

    public void setBytesValue(byte[] bytesValue) {
        this.bytesValue = bytesValue;
        if (bytesValue != null)
            this.length = bytesValue.length;
    }

    public Object getValue() {
        return ParameterUtils.toValue(id, bytesValue);
    }
}