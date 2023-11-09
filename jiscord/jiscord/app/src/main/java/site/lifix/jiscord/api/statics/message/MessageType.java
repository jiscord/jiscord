package site.lifix.jiscord.api.statics.message;

import com.google.gson.JsonElement;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class MessageType extends BaseObject {
    // A default message (see below)
    // Rendered content: "{content}"
    // Deletable
    public static final int DEFAULT = 0;

    // A message sent when a user is added to a group DM or thread
    // Rendered content: "{author} added {mentions[0]} to the {group/thread}."
    // Not deletable
    public static final int RECIPIENT_ADD = 1;

    // A message sent when a user is removed from a group DM or thread
    // Rendered content: "{author} removed {mentions[0]} from the {group/thread}."
    // Not deletable
    public static final int RECIPIENT_REMOVE = 2;

    // A message sent when a user creates a call in a private channel
    // Rendered content: participated
    //  ? "{author} started a call{ended ? " that lasted {duration}" : " — Join the call"}."
    //  : "You missed a call from {author} that lasted {duration}."
    // Not deletable
    public static final int CALL = 3;

    // A message sent when a group DM or thread's name is changed
    // Rendered content: "{author} changed the {is_forum ? "post title" : "channel name"}: {content}"
    // Not deletable
    public static final int CHANNEL_NAME_CHANGE = 4;

    // A message sent when a group DM's icon is changed
    // Rendered content: "{author} changed the channel icon."
    // Not deletable
    public static final int CHANNEL_ICON_CHANGE = 5;

    // A message sent when a message is pinned in a channel
    // Rendered content: "{author} pinned a message to this channel."
    // Deletable
    public static final int CHANNEL_PINNED_MESSAGE = 6;

    // A message sent when a user joins a guild
    // Rendered content: See user join message type, obtained via the formula timestamp_ms % 13
    // Deletable
    public static final int USER_JOIN = 7;

    // A message sent when a user subscribes to (boosts) a guild
    // Rendered content: "{author} just boosted the server{content ? " {content} times"}!"
    // Deletable
    public static final int PREMIUM_GUILD_SUBSCRIPTION = 8;

    // A message sent when a user subscribes to (boosts) a guild to tier 1
    // Rendered content: "{author} just boosted the server{content ? " {content} times"}! {guild} has achieved Level 1!"
    // Deletable
    public static final int PREMIUM_GUILD_SUBSCRIPTION_TIER_1 = 9;

    // A message sent when a user subscribes to (boosts) a guild to tier 2
    // Rendered content: "{author} just boosted the server{content ? " {content} times"}! {guild} has achieved Level 2!"
    // Deletable
    public static final int PREMIUM_GUILD_SUBSCRIPTION_TIER_2 = 10;

    // A message sent when a user subscribes to (boosts) a guild to tier 3
    // Rendered content: "{author} just boosted the server{content ? " {content} times"}! {guild} has achieved Level 3!"
    // Deletable
    public static final int PREMIUM_GUILD_SUBSCRIPTION_TIER_3 = 11;

    // A message sent when a news channel is followed
    // Rendered content: "{author} has added {content} to this channel. Its most important updates will show up here."
    // Deletable
    public static final int CHANNEL_FOLLOW_ADD = 12;

    // A message sent when a user starts streaming in a guild
    // Not deletable
    public static final int GUILD_STREAM = 13;

    // A message sent when a guild is disqualified from discovery
    // Rendered content: "This server has been removed from Server Discovery because it no longer passes all the
    //  requirements. Check Server Settings for more details."
    // Not deletable
    public static final int GUILD_DISCOVERY_DISQUALIFIED = 14;

    // A message sent when a guild requalifies for discovery
    // Rendered content: "This server is eligible for Server Discovery again and has been automatically relisted!"
    // Not deletable
    public static final int GUILD_DISCOVERY_REQUALIFIED = 15;

    // A message sent when a guild has failed discovery requirements for a week
    // Rendered content: "This server has failed Discovery activity requirements for 1 week. If this server fails for 4
    //  weeks in a row, it will be automatically removed from Discovery."
    // Not deletable
    public static final int GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING = 16;

    // A message sent when a guild has failed discovery requirements for 3 weeks
    // Rendered content: "This server has failed Discovery activity requirements for 3 weeks in a row. If this server
    //  fails for 1 more week, it will be removed from Discovery."
    // Not deletable
    public static final int GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING = 17;

    // A message sent when a thread is created
    // Rendered content: "{author} started a thread: {content}. See all threads."
    // Deletable
    public static final int THREAD_CREATED = 18;

    // A message sent when a user replies to a message
    // Rendered content: "{content}"
    // Deletable
    public static final int REPLY = 19;

    // A message sent when a user uses a slash command
    // Rendered content: "{content}"
    // Deletable
    public static final int CHAT_INPUT_COMMAND = 20;

    // A message sent when a thread starter message is added to a thread
    // Rendered content: "{referenced_message?.content}" ?? "Sorry, we couldn't load the first message in this thread"
    // Not deletable
    public static final int THREAD_STARTER_MESSAGE = 21;

    // A message sent to remind users to invite friends to a guild
    // Rendered content: "Wondering who to invite?\nStart by inviting anyone who can help you build the server!"
    // Deletable
    public static final int GUILD_INVITE_REMINDER = 22;

    // A message sent when a user uses a context menu command
    // Rendered content: "{content}"
    // Deletable
    public static final int CONTEXT_MENU_COMMAND = 23;

    // A message sent when auto moderation takes an action
    // Rendered content: Special embed rendered from {embeds[0]}
    // Deletable by users with "Manage messages" permission
    public static final int AUTO_MODERATION_ACTION = 24;

    // A message sent when a user purchases or renews a role subscription
    // Rendered content: "{author} {is_renewal ? "renewed" : "joined"} {role_subscription.tier_name} and has been a
    //  subscriber of {guild} for {role_subscription.total_months_subscribed} month(?s)!"
    // Deletable
    public static final int ROLE_SUBSCRIPTION_PURCHASE = 25;

    // A message sent when a user is upsold to a premium interaction
    // Rendered content: "{content}"
    // Deletable
    public static final int INTERACTION_PREMIUM_UPSELL = 26;

    // A message sent when a stage channel starts
    // Rendered content: "{author} started {content}"
    // Deletable
    public static final int STAGE_START = 27;

    // A message sent when a stage channel ends
    // Rendered content: "{author} ended {content}"
    // Deletable
    public static final int STAGE_END = 28;

    // A message sent when a user starts speaking in a stage channel
    // Rendered content: "{author} is now a speaker."
    // Deletable
    public static final int STAGE_SPEAKER = 29;

    // A message sent when a user raises their hand in a stage channel
    // Rendered content: "{author} requested to speak."
    // Deletable
    public static final int STAGE_RAISE_HAND = 30;

    // A message sent when a stage channel's topic is changed
    // Rendered content: "{author} changed the Stage topic: {content}"
    // Deletable
    public static final int STAGE_TOPIC = 31;

    // A message sent when a user purchases an application premium subscription
    // Rendered content: "{author} upgraded {application ?? "a deleted application"} to premium for this server!"
    // Deletable
    public static final int GUILD_APPLICATION_PREMIUM_SUBSCRIPTION = 32;

    // A message sent when a user adds an application to group DM
    // Rendered content: "{author} added {"the {application} app" ?? "a deleted application"}. See our Help Centre
    //  for more info."
    // Not deletable
    public static final int PRIVATE_CHANNEL_INTEGRATION_ADDED = 33;

    // A message sent when a user removed an application from a group DM
    // Rendered content: "{author} removed {"the {application} app" ?? "a deleted application"}. See our Help Centre
    //  for more info."
    // Not deletable
    public static final int PRIVATE_CHANNEL_INTEGRATION_REMOVED = 34;

    // A message sent when a user gifts a premium (Nitro) referral
    // Rendered content: "{content}"
    // Deletable
    public static final int PREMIUM_REFERRAL = 35;

    // A message sent when a user enabled lockdown for the guild
    // Rendered content: "{author} locked {guild} until {content}."
    // Not deletable
    public static final int GUILD_INCIDENT_ALERT_MODE_ENABLED = 36;

    // A message sent when a user disables lockdown for the guild
    // Rendered content: "{author} disabled server lockdown."
    // Not deletable
    public static final int GUILD_INCIDENT_ALERT_MODE_DISABLED = 37;

    // A message sent when a user reports a raid for the guild
    // Rendered content: "{author} reported a raid in {guild}."
    // Not deletable
    public static final int GUILD_INCIDENT_REPORT_RAID = 38;

    // A message sent when a user reports a false alarm for the guild
    // Rendered content: "{author} reported a false alarm in {guild}."
    // Not deletable
    public static final int GUILD_INCIDENT_REPORT_FALSE_ALARM = 39;

    // A message sent when no one sends a message in the current channel for 1 hour
    // Rendered content: "{author} reported a false alarm in {guild}."
    // Not deletable
    public static final int GUILD_DEADCHAT_REVIVE_PROMPT = 40;

    // Rendered content: "{content}"
    // Not deletable
    public static final int GUILD_GAMING_STATS_PROMPT = 42;

    public MessageType(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageType(OptionalJsonValue<?> data) {
        super(data);
    }
}
