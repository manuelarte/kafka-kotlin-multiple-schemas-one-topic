/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.manuelarte.kafka.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** User updated his email */
@org.apache.avro.specific.AvroGenerated
public class UserEmailUpdatedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3263325722081050403L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserEmailUpdatedEvent\",\"namespace\":\"com.github.manuelarte.kafka.avro\",\"doc\":\"User updated his email\",\"fields\":[{\"name\":\"id\",\"type\":\"int\",\"doc\":\"The id of the user\"},{\"name\":\"email\",\"type\":\"string\",\"doc\":\"The new email of the user\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserEmailUpdatedEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserEmailUpdatedEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserEmailUpdatedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserEmailUpdatedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserEmailUpdatedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserEmailUpdatedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserEmailUpdatedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserEmailUpdatedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserEmailUpdatedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The id of the user */
  private int id;
  /** The new email of the user */
  private java.lang.CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserEmailUpdatedEvent() {}

  /**
   * All-args constructor.
   * @param id The id of the user
   * @param email The new email of the user
   */
  public UserEmailUpdatedEvent(java.lang.Integer id, java.lang.CharSequence email) {
    this.id = id;
    this.email = email;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: email = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The id of the user
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * The id of the user
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The new email of the user
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * The new email of the user
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Creates a new UserEmailUpdatedEvent RecordBuilder.
   * @return A new UserEmailUpdatedEvent RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder newBuilder() {
    return new com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder();
  }

  /**
   * Creates a new UserEmailUpdatedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserEmailUpdatedEvent RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder newBuilder(com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder other) {
    if (other == null) {
      return new com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder();
    } else {
      return new com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder(other);
    }
  }

  /**
   * Creates a new UserEmailUpdatedEvent RecordBuilder by copying an existing UserEmailUpdatedEvent instance.
   * @param other The existing instance to copy.
   * @return A new UserEmailUpdatedEvent RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder newBuilder(com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent other) {
    if (other == null) {
      return new com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder();
    } else {
      return new com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserEmailUpdatedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserEmailUpdatedEvent>
    implements org.apache.avro.data.RecordBuilder<UserEmailUpdatedEvent> {

    /** The id of the user */
    private int id;
    /** The new email of the user */
    private java.lang.CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing UserEmailUpdatedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * The id of the user
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * The id of the user
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * The id of the user
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * The id of the user
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * The new email of the user
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * The new email of the user
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.email = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * The new email of the user
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'email' field.
      * The new email of the user
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent.Builder clearEmail() {
      email = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEmailUpdatedEvent build() {
      try {
        UserEmailUpdatedEvent record = new UserEmailUpdatedEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.email = fieldSetFlags()[1] ? this.email : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserEmailUpdatedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserEmailUpdatedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserEmailUpdatedEvent>
    READER$ = (org.apache.avro.io.DatumReader<UserEmailUpdatedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.id);

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readInt();

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readInt();
          break;

        case 1:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










