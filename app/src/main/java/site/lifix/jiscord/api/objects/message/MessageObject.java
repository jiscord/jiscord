package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.channel.ChannelObject;
import site.lifix.jiscord.api.objects.channel.PartialChannelObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.api.objects.integration.IntegrationApplicationObject;
import site.lifix.jiscord.api.objects.interactions.MessageComponentObject;
import site.lifix.jiscord.api.objects.interactions.MessageInteractionObject;
import site.lifix.jiscord.api.objects.sticker.StickerItemObject;
import site.lifix.jiscord.api.objects.sticker.StickerObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class MessageObject extends BaseObject {
    // The ID of the message
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The ID of the channel the message was sent in
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // The ID of the guild the message was sent in
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The author of the message
    @Getter private final OptionalJsonValue<UserObject> author
            = new OptionalJsonValue<>(this, "author", UserObject.class);

    // Guild member data for this message's author
    @Getter private final OptionalJsonValue<GuildMemberObject> member
            = new OptionalJsonValue<>(this, "member", GuildMemberObject.class);

    // Contents of the message
    @Getter private final OptionalJsonValue<String> content
            = new OptionalJsonValue<>(this, "content", String.class);

    // When this message was sent
    @Getter private final OptionalJsonValue<String> timestamp
            = new OptionalJsonValue<>(this, "timestamp", String.class);

    // when this message was last edited
    @Getter private final OptionalJsonValue<String> editedTimestamp
            = new OptionalJsonValue<>(this, "edited_timestamp", String.class);

    // Whether this message will be read out by TTS
    @Getter private final OptionalJsonValue<Boolean> tts
            = new OptionalJsonValue<>(this, "tts", Boolean.class);

    // Whether this message mentions everyone
    @Getter private final OptionalJsonValue<Boolean> mentionEveryone
            = new OptionalJsonValue<>(this, "mention_everyone", Boolean.class);

    // Users specifically mentioned in the message
    private final OptionalJsonValue<JsonArray> mentions
            = new OptionalJsonValue<>(this, "mentions", JsonArray.class);

    // Roles specifically mentioned in this message
    private final OptionalJsonValue<JsonArray> mentionRoles
            = new OptionalJsonValue<>(this, "mention_roles", JsonArray.class);

    // Channels specifically mentioned in this message
    private final OptionalJsonValue<JsonArray> mentionChannels
            = new OptionalJsonValue<>(this, "mention_channels", JsonArray.class);

    // The attached files
    private final OptionalJsonValue<JsonArray> attachments
            = new OptionalJsonValue<>(this, "attachments", JsonArray.class);

    // Content embedded in the message
    private final OptionalJsonValue<JsonArray> embeds
            = new OptionalJsonValue<>(this, "embeds", JsonArray.class);

    // Reactions on the message
    private final OptionalJsonValue<JsonArray> reactions
            = new OptionalJsonValue<>(this, "reactions", JsonArray.class);

    // The message's nonce, used for message deduplication
    @Getter private final OptionalJsonValue<String> nonce
            = new OptionalJsonValue<>(this, "nonce", String.class);

    // Whether this message is pinned
    @Getter private final OptionalJsonValue<Boolean> pinned
            = new OptionalJsonValue<>(this, "pinned", Boolean.class);

    // The ID of the webhook that send the message
    @Getter private final OptionalJsonValue<String> webhookId
            = new OptionalJsonValue<>(this, "webhook_id", String.class);

    // The type of message
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // The rich presence activity the author is inviting users to
    @Getter private final OptionalJsonValue<MessageActivityObject> activity
            = new OptionalJsonValue<>(this, "activity", MessageActivityObject.class);

    // The application of the message's rich presence activity
    @Getter private final OptionalJsonValue<IntegrationApplicationObject> application
            = new OptionalJsonValue<>(this, "application", IntegrationApplicationObject.class);

    // The ID of the application; only send for interaction responses
    @Getter private final OptionalJsonValue<String> applicationId
            = new OptionalJsonValue<>(this, "application_id", String.class);

    // The source of a crosspost, channel follow add, pin, or reply message
    @Getter private final OptionalJsonValue<MessageReferenceObject> messageReference
            = new OptionalJsonValue<>(this, "message_reference", MessageReferenceObject.class);

    // The message's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // The message associated with the message_reference
    @Getter private final OptionalJsonValue<MessageObject> referencedMessage
            = new OptionalJsonValue<>(this, "referenced_message", MessageObject.class);

    // The private channel call that prompted this message
    @Getter private final OptionalJsonValue<MessageCallObject> call
            = new OptionalJsonValue<>(this, "call", MessageCallObject.class);

    // The interaction the message is responding to
    @Getter private final OptionalJsonValue<MessageInteractionObject> interaction
            = new OptionalJsonValue<>(this, "interaction", MessageInteractionObject.class);

    // The thread that was started from this message, with the member key representing thread member data
    @Getter private final OptionalJsonValue<ChannelObject> thread
            = new OptionalJsonValue<>(this, "thread", ChannelObject.class);

    // The role subscription purchase or renewal that prompted this message
    @Getter private final OptionalJsonValue<MessageRoleSubscriptionObject> roleSubscriptionData
            = new OptionalJsonValue<>(this, "role_subscription_data", MessageRoleSubscriptionObject.class);

    // The message's components (e.g. buttons, select menus)
    private final OptionalJsonValue<JsonArray> components
            = new OptionalJsonValue<>(this, "components", JsonArray.class);

    // The message's sticker items
    private final OptionalJsonValue<JsonArray> stickerItems
            = new OptionalJsonValue<>(this, "sticker_items", JsonArray.class);

    // Extra rich information for the message's sticker items; only available in some contexts
    private final OptionalJsonValue<JsonArray> stickers
            = new OptionalJsonValue<>(this, "stickers", JsonArray.class);

    public List<UserObject> getMentions() {
        return Utility.mappedJsonArray(this.mentions, UserObject::new);
    }

    public List<String> getMentionRoles() {
        return Utility.mappedJsonArray(this.mentionRoles, JsonElement::getAsString);
    }

    public List<PartialChannelObject> getMentionChannels() {
        return Utility.mappedJsonArray(this.mentionChannels, PartialChannelObject::new);
    }

    public List<AttachmentObject> getAttachments() {
        return Utility.mappedJsonArray(this.attachments, AttachmentObject::new);
    }

    public List<EmbedObject> getEmbeds() {
        return Utility.mappedJsonArray(this.embeds, EmbedObject::new);
    }

    public List<ReactionObject> getReactions() {
        return Utility.mappedJsonArray(this.reactions, ReactionObject::new);
    }

    public List<MessageComponentObject> getComponents() {
        return Utility.mappedJsonArray(this.components, MessageComponentObject::new);
    }

    public List<StickerItemObject> getStickerItems() {
        return Utility.mappedJsonArray(this.stickerItems, StickerItemObject::new);
    }

    public List<StickerObject> getStickers() {
        return Utility.mappedJsonArray(this.stickers, StickerObject::new);
    }

    public MessageObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
