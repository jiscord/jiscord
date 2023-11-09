package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ChannelObject extends BaseObject {
    // The ID of the channel
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The type of channel
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // The ID of the guild the channel is in
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // Sorting position of the channel
    @Getter private final OptionalJsonValue<Integer> position
            = new OptionalJsonValue<>(this, "position", Integer.class);

    // Explicit permission overwrites for members and roles
    private final OptionalJsonValue<JsonArray> permissionOverwrites
            = new OptionalJsonValue<>(this, "permission_overwrites", JsonArray.class);

    // The name of the channel (1-100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The channel topic (max 4096 characters for thread-only channels, max 1024 characters otherwise)
    @Getter private final OptionalJsonValue<String> topic
            = new OptionalJsonValue<>(this, "topic", String.class);

    // Whether the channel is NSFW
    @Getter private final OptionalJsonValue<Boolean> nsfw
            = new OptionalJsonValue<>(this, "nsfw", Boolean.class);

    // The ID of the last message sent (or thread created for thread-only channels, guild added for directory channels)
    //  in this channel (may not point to an existing resource)
    @Getter private final OptionalJsonValue<String> lastMessageId
            = new OptionalJsonValue<>(this, "last_message_id", String.class);

    // The bitrate (in bits) of the voice channel
    @Getter private final OptionalJsonValue<Integer> bitrate
            = new OptionalJsonValue<>(this, "bitrate", Integer.class);

    // The user limit of the voice channel (max 1000, 0 refers to no limit)
    @Getter private final OptionalJsonValue<Integer> userLimit
            = new OptionalJsonValue<>(this, "user_limit", Integer.class);

    // Duration in seconds seconds a user has to wait before sending another message (max 21600); bots, as well as
    //  users with the permission MANAGE_MESSAGES or MANAGE_CHANNELS, are unaffected
    @Getter private final OptionalJsonValue<Integer> rateLimitPerUser
            = new OptionalJsonValue<>(this, "rate_limit_per_user", Integer.class);

    // The recipients of the private channel
    private final OptionalJsonValue<JsonArray> recipients
            = new OptionalJsonValue<>(this, "recipients", JsonArray.class);

    // The group DM's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // Whether the group DM is managed by an application
    @Getter private final OptionalJsonValue<Boolean> managed
            = new OptionalJsonValue<>(this, "managed", Boolean.class);

    // The ID of the application that manages the group DM
    @Getter private final OptionalJsonValue<String> applicationId
            = new OptionalJsonValue<>(this, "application_id", String.class);

    // The ID of the owner of the group DM or thread
    @Getter private final OptionalJsonValue<String> ownerId
            = new OptionalJsonValue<>(this, "owner_id", String.class);

    // The owner of this thread; only included on certain API endpoints
    @Getter private final OptionalJsonValue<GuildMemberObject> owner
            = new OptionalJsonValue<>(this, "owner", GuildMemberObject.class);

    // The ID of the parent category/channel for the guild channel/thread
    @Getter private final OptionalJsonValue<String> parentId
            = new OptionalJsonValue<>(this, "parent_id", String.class);

    // When the last pinned message was pinned, if any
    @Getter private final OptionalJsonValue<String> lastPinTimestamp
            = new OptionalJsonValue<>(this, "last_pin_timestamp", String.class);

    // The voice region ID for the voice channel (automatic when null)
    @Getter private final OptionalJsonValue<String> rtcRegion
            = new OptionalJsonValue<>(this, "rtc_region", String.class);

    // The camera video quality mode of the voice channel (default AUTO)
    @Getter private final OptionalJsonValue<Integer> videoQualityMode
            = new OptionalJsonValue<>(this, "video_quality_mode", Integer.class);

    // The number of messages ever sent in a thread; similar to message_count on message creation, but will not
    //  decrement the number when a message is deleted
    @Getter private final OptionalJsonValue<Integer> totalMessageSent
            = new OptionalJsonValue<>(this, "total_message_sent", Integer.class);

    // The number of messages (not including the initial message or deleted messages) in a thread (if the thread was
    //  created before July 1, 2022, it stops counting at 50)
    @Getter private final OptionalJsonValue<Integer> messageCount
            = new OptionalJsonValue<>(this, "message_count", Integer.class);

    // An approximate count of users in a thread, stops counting at 50
    @Getter private final OptionalJsonValue<Integer> memberCount
            = new OptionalJsonValue<>(this, "member_count", Integer.class);

    // The IDs of some of the members in a thread
    private final OptionalJsonValue<JsonArray> memberIdsPreview
            = new OptionalJsonValue<>(this, "member_ids_preview", JsonArray.class);

    // Thread-specific channel metadata
    @Getter private final OptionalJsonValue<ThreadMetadataObject> threadMetadata
            = new OptionalJsonValue<>(this, "thread_metadata", ThreadMetadataObject.class);

    // Thread member object for the current user, if they have joined the thread; only included on certain API endpoints
    @Getter private final OptionalJsonValue<ThreadMemberObject> member
            = new OptionalJsonValue<>(this, "member", ThreadMemberObject.class);

    // Default duration in minutes for newly created threads to stop showing in the channel list after inactivity (one
    //  of 60, 1440, 4320, 10080)
    @Getter private final OptionalJsonValue<Integer> defaultAutoArchiveDuration
            = new OptionalJsonValue<>(this, "default_auto_archive_duration", Integer.class);

    // Default duration in seconds a user has to wait before sending another message in newly created threads; this
    //  field is copied to the thread at creation time and does not live update
    @Getter private final OptionalJsonValue<Integer> defaultThreadRateLimitPerUser
            = new OptionalJsonValue<>(this, "default_thread_rate_limit_per_user", Integer.class);

    // Computed permissions for the invoking user in the channel, including overwrites
    @Getter private final OptionalJsonValue<String> permissions
            = new OptionalJsonValue<>(this, "permissions", String.class);

    // The channel's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // The tags that can be used in a thread-only channel (max 20)
    private final OptionalJsonValue<JsonArray> availableTags
            = new OptionalJsonValue<>(this, "available_tags", JsonArray.class);

    // The IDs of tags that are applied to a thread in a thread-only channel (max 5)
    private final OptionalJsonValue<JsonArray> appliedTags
            = new OptionalJsonValue<>(this, "applied_tags", JsonArray.class);

    // The emoji to show in the add reaction button on a thread in a thread-only channel
    @Getter private final OptionalJsonValue<DefaultReactionObject> defaultReactionEmoji
            = new OptionalJsonValue<>(this, "default_reaction_emoji", DefaultReactionObject.class);

    // The default layout of a thread-only channel
    @Getter private final OptionalJsonValue<Integer> defaultForumLayout
            = new OptionalJsonValue<>(this, "default_forum_layout", Integer.class);

    // The default sort order of a thread-only channel's threads (default LATEST_ACTIVITY)
    @Getter private final OptionalJsonValue<Integer> defaultSortOrder
            = new OptionalJsonValue<>(this, "default_sort_order", Integer.class);

    public List<PermissionOverwriteObject> getPermissionOverwrites() {
        return Utility.mappedJsonArray(this.permissionOverwrites, PermissionOverwriteObject::new);
    }

    public List<UserObject> getRecipients() {
        return Utility.mappedJsonArray(this.recipients, UserObject::new);
    }

    public List<String> getMemberIdsPreview() {
        return Utility.mappedJsonArray(this.memberIdsPreview, JsonElement::getAsString);
    }

    public List<ForumTagObject> getAvailableTags() {
        return Utility.mappedJsonArray(this.availableTags, ForumTagObject::new);
    }

    public List<String> getAppliedTags() {
        return Utility.mappedJsonArray(this.appliedTags, JsonElement::getAsString);
    }

    public ChannelObject(JsonElement data) {
        super(data);
    }

    public ChannelObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
