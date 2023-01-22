package edu.henriqueborba.fwcalbumapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "sticker_user")
@NoArgsConstructor
public class StickerUser {

    @EmbeddedId
    @JsonIgnore
    private StickerUserPk id;

    private Integer amount;

    public StickerUser(User user, Sticker sticker, Integer amount) {
        this.id = new StickerUserPk(user, sticker);
        this.amount = amount;
    }

    @JsonIgnore
    public User getUser()
    {
        return this.id.getUser();
    }

    public void setUser(User user)
    {
        this.id.setUser(user);
    }

    public Sticker getSticker()
    {
        return this.id.getSticker();
    }

    public void setSticker(Sticker sticker)
    {
        this.id.setSticker(sticker);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StickerUser that = (StickerUser) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
