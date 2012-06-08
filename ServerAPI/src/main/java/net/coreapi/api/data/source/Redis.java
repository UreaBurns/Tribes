package net.coreapi.api.data.source;

import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 5/17/12 3:37 PM
 */
public class Redis
{
    private static final Jedis jedis = new Jedis("localhost");
    private static Redis instance = new Redis();
    {
        connect();
    }
    private Redis()
    {
        connect();
        if (isConnected()) {

        }
        else {

        }
    }

    public static String ping()
    {
        return jedis.ping();
    }

    public static String quit()
    {
        return jedis.quit();
    }

    public static Set<String> keys(String pattern)
    {
        return jedis.keys(pattern);
    }

    public static String rpop(String key)
    {
        return jedis.rpop(key);
    }

    public static Set<String> zrange(String key, int start, int end)
    {
        return jedis.zrange(key,
                            start,
                            end);
    }

    public static Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value)
    {
        return jedis.linsert(key,
                             where,
                             pivot,
                             value);
    }

    public static Set<String> sdiff(String... keys)
    {
        return jedis.sdiff(keys);
    }

    public static Long rpush(byte[] key, byte[] string)
    {
        return jedis.rpush(key,
                           string);
    }

    public static Long setbit(byte[] key, long offset, byte[] value)
    {
        return jedis.setbit(key,
                            offset,
                            value);
    }

    public static List<Object> multi(TransactionBlock jedisTransaction)
    {
        return jedis.multi(jedisTransaction);
    }

    public static Long incr(String key)
    {
        return jedis.incr(key);
    }

    public static String setex(byte[] key, int seconds, byte[] value)
    {
        return jedis.setex(key,
                           seconds,
                           value);
    }

    public static List<byte[]> sort(byte[] key)
    {
        return jedis.sort(key);
    }

    public static Set<Tuple> zrevrangeWithScores(byte[] key, int start, int end)
    {
        return jedis.zrevrangeWithScores(key,
                                         start,
                                         end);
    }

    public static Long move(String key, int dbIndex)
    {
        return jedis.move(key,
                          dbIndex);
    }

    public static List<String> sort(String key, SortingParams sortingParameters)
    {
        return jedis.sort(key,
                          sortingParameters);
    }

    public static Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count)
    {
        return jedis.zrangeByScoreWithScores(key,
                                             min,
                                             max,
                                             offset,
                                             count);
    }

    public static Long incrBy(byte[] key, long integer)
    {
        return jedis.incrBy(key,
                            integer);
    }

    public static Long sunionstore(byte[] dstkey, byte[]... keys)
    {
        return jedis.sunionstore(dstkey,
                                 keys);
    }

    public static byte[] hget(byte[] key, byte[] field)
    {
        return jedis.hget(key,
                          field);
    }

    public static Boolean sismember(byte[] key, byte[] member)
    {
        return jedis.sismember(key,
                               member);
    }

    public static String hmset(String key, Map<String, String> hash)
    {
        return jedis.hmset(key,
                           hash);
    }

    public static Long zinterstore(byte[] dstkey, byte[]... sets)
    {
        return jedis.zinterstore(dstkey,
                                 sets);
    }

    public static String getSet(String key, String value)
    {
        return jedis.getSet(key,
                            value);
    }

    public static Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max,
                                   offset,
                                   count);
    }

    public static String mset(byte[]... keysvalues)
    {
        return jedis.mset(keysvalues);
    }

    public static Long renamenx(byte[] oldkey, byte[] newkey)
    {
        return jedis.renamenx(oldkey,
                              newkey);
    }

    public static String lset(String key, long index, String value)
    {
        return jedis.lset(key,
                          index,
                          value);
    }

    public static byte[] substr(byte[] key, int start, int end)
    {
        return jedis.substr(key,
                            start,
                            end);
    }

    public static Set<String> zrangeByScore(String key, double min, double max)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max);
    }

    public static Long renamenx(String oldkey, String newkey)
    {
        return jedis.renamenx(oldkey,
                              newkey);
    }

    public static Long zinterstore(String dstkey, String... sets)
    {
        return jedis.zinterstore(dstkey,
                                 sets);
    }

    public static Long sinterstore(String dstkey, String... keys)
    {
        return jedis.sinterstore(dstkey,
                                 keys);
    }

    public static Long rpushx(String key, String string)
    {
        return jedis.rpushx(key,
                            string);
    }

    public static byte[] lindex(byte[] key, int index)
    {
        return jedis.lindex(key,
                            index);
    }

    public static Set<byte[]> sunion(byte[]... keys)
    {
        return jedis.sunion(keys);
    }

    public static Long ttl(String key)
    {
        return jedis.ttl(key);
    }

    public static List<byte[]> blpop(int timeout, byte[]... keys)
    {
        return jedis.blpop(timeout,
                           keys);
    }

    public static Long sort(String key, SortingParams sortingParameters, String dstkey)
    {
        return jedis.sort(key,
                          sortingParameters,
                          dstkey);
    }

    public static Long zrem(String key, String member)
    {
        return jedis.zrem(key,
                          member);
    }

    public static Long rpush(String key, String string)
    {
        return jedis.rpush(key,
                           string);
    }

    public static Long sort(byte[] key, SortingParams sortingParameters, byte[] dstkey)
    {
        return jedis.sort(key,
                          sortingParameters,
                          dstkey);
    }

    public static Set<Tuple> zrevrangeWithScores(String key, int start, int end)
    {
        return jedis.zrevrangeWithScores(key,
                                         start,
                                         end);
    }

    public static String select(int index)
    {
        return jedis.select(index);
    }

    public static Long hsetnx(byte[] key, byte[] field, byte[] value)
    {
        return jedis.hsetnx(key,
                            field,
                            value);
    }

    public static Set<String> sunion(String... keys)
    {
        return jedis.sunion(keys);
    }

    public static List<String> configGet(String pattern)
    {
        return jedis.configGet(pattern);
    }

    public static String get(String key)
    {
        return jedis.get(key);
    }

    public static Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min,
                                      offset,
                                      count);
    }

    public static Long zadd(String key, double score, String member)
    {
        return jedis.zadd(key,
                          score,
                          member);
    }

    public static Boolean exists(byte[] key)
    {
        return jedis.exists(key);
    }

    public static String echo(String string)
    {
        return jedis.echo(string);
    }

    public static Long sort(String key, String dstkey)
    {
        return jedis.sort(key,
                          dstkey);
    }

    public static void disconnect()
    {
        jedis.disconnect();
    }

    public static Long llen(String key)
    {
        return jedis.llen(key);
    }

    public static String configResetStat()
    {
        return jedis.configResetStat();
    }

    public static Long expireAt(byte[] key, long unixTime)
    {
        return jedis.expireAt(key,
                              unixTime);
    }

    public static String srandmember(String key)
    {
        return jedis.srandmember(key);
    }

    public static Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max);
    }

    public static void psubscribe(JedisPubSub jedisPubSub, String... patterns)
    {
        jedis.psubscribe(jedisPubSub,
                         patterns);
    }

    public static Long sadd(String key, String member)
    {
        return jedis.sadd(key,
                          member);
    }

    public static Long smove(byte[] srckey, byte[] dstkey, byte[] member)
    {
        return jedis.smove(srckey,
                           dstkey,
                           member);
    }

    public static Long sdiffstore(byte[] dstkey, byte[]... keys)
    {
        return jedis.sdiffstore(dstkey,
                                keys);
    }

    public static Set<byte[]> zrange(byte[] key, int start, int end)
    {
        return jedis.zrange(key,
                            start,
                            end);
    }

    public static Long decr(String key)
    {
        return jedis.decr(key);
    }

    public static Long incrBy(String key, long integer)
    {
        return jedis.incrBy(key,
                            integer);
    }

    public static byte[] brpoplpush(byte[] source, byte[] destination, int timeout)
    {
        return jedis.brpoplpush(source,
                                destination,
                                timeout);
    }

    public static Long zunionstore(String dstkey, String... sets)
    {
        return jedis.zunionstore(dstkey,
                                 sets);
    }

    public static long setrange(byte[] key, long offset, byte[] value)
    {
        return jedis.setrange(key,
                              offset,
                              value);
    }

    public static Set<String> zrangeByScore(String key, double min, double max, int offset, int count)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max,
                                   offset,
                                   count);
    }

    public static byte[] rpop(byte[] key)
    {
        return jedis.rpop(key);
    }

    public static Long scard(String key)
    {
        return jedis.scard(key);
    }

    public static Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min)
    {
        return jedis.zrevrangeByScoreWithScores(key,
                                                max,
                                                min);
    }

    public static Long publish(byte[] channel, byte[] message)
    {
        return jedis.publish(channel,
                             message);
    }

    public static Set<Tuple> zrangeByScoreWithScores(String key, double min, double max)
    {
        return jedis.zrangeByScoreWithScores(key,
                                             min,
                                             max);
    }

    public static Long expire(String key, int seconds)
    {
        return jedis.expire(key,
                            seconds);
    }

    public static byte[] lpop(byte[] key)
    {
        return jedis.lpop(key);
    }

    public static Long hincrBy(String key, String field, long value)
    {
        return jedis.hincrBy(key,
                             field,
                             value);
    }

    public static byte[] randomBinaryKey()
    {
        return jedis.randomBinaryKey();
    }

    public static Boolean exists(String key)
    {
        return jedis.exists(key);
    }

    public static Client getClient()
    {
        return jedis.getClient();
    }

    public static byte[] spop(byte[] key)
    {
        return jedis.spop(key);
    }

    public static String watch(byte[]... keys)
    {
        return jedis.watch(keys);
    }

    public static Set<String> zrevrange(String key, int start, int end)
    {
        return jedis.zrevrange(key,
                               start,
                               end);
    }

    public static String lpop(String key)
    {
        return jedis.lpop(key);
    }

    public static String bgsave()
    {
        return jedis.bgsave();
    }

    public static Long hdel(byte[] key, byte[] field)
    {
        return jedis.hdel(key,
                          field);
    }

    public static Long append(String key, String value)
    {
        return jedis.append(key,
                            value);
    }

    public static Set<byte[]> keys(byte[] pattern)
    {
        return jedis.keys(pattern);
    }

    public static List<String> lrange(String key, long start, long end)
    {
        return jedis.lrange(key,
                            start,
                            end);
    }

    public static List<byte[]> hvals(byte[] key)
    {
        return jedis.hvals(key);
    }

    public static Long zremrangeByScore(byte[] key, double start, double end)
    {
        return jedis.zremrangeByScore(key,
                                      start,
                                      end);
    }

    public static Long sadd(byte[] key, byte[] member)
    {
        return jedis.sadd(key,
                          member);
    }

    public static Long lastsave()
    {
        return jedis.lastsave();
    }

    public static Map<String, String> hgetAll(String key)
    {
        return jedis.hgetAll(key);
    }

    public static String brpoplpush(String source, String destination, int timeout)
    {
        return jedis.brpoplpush(source,
                                destination,
                                timeout);
    }

    public static Long zrevrank(String key, String member)
    {
        return jedis.zrevrank(key,
                              member);
    }

    public static byte[] get(byte[] key)
    {
        return jedis.get(key);
    }

    public static Long zunionstore(String dstkey, ZParams params, String... sets)
    {
        return jedis.zunionstore(dstkey,
                                 params,
                                 sets);
    }

    public static Long srem(String key, String member)
    {
        return jedis.srem(key,
                          member);
    }

    public static Long del(byte[]... keys)
    {
        return jedis.del(keys);
    }

    public static Long zcount(byte[] key, double min, double max)
    {
        return jedis.zcount(key,
                            min,
                            max);
    }

    public static Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count)
    {
        return jedis.zrevrangeByScoreWithScores(key,
                                                max,
                                                min,
                                                offset,
                                                count);
    }

    public static String getrange(String key, long startOffset, long endOffset)
    {
        return jedis.getrange(key,
                              startOffset,
                              endOffset);
    }

    public static Long hset(byte[] key, byte[] field, byte[] value)
    {
        return jedis.hset(key,
                          field,
                          value);
    }

    public static Double zscore(byte[] key, byte[] member)
    {
        return jedis.zscore(key,
                            member);
    }

    public static Long rpushx(byte[] key, byte[] string)
    {
        return jedis.rpushx(key,
                            string);
    }

    public static Long zrank(String key, String member)
    {
        return jedis.zrank(key,
                           member);
    }

    public static Long msetnx(String... keysvalues)
    {
        return jedis.msetnx(keysvalues);
    }

    public static String lindex(String key, long index)
    {
        return jedis.lindex(key,
                            index);
    }

    public static List<byte[]> mget(byte[]... keys)
    {
        return jedis.mget(keys);
    }

    public static String shutdown()
    {
        return jedis.shutdown();
    }

    public static String slaveofNoOne()
    {
        return jedis.slaveofNoOne();
    }

    public static String hmset(byte[] key, Map<byte[], byte[]> hash)
    {
        return jedis.hmset(key,
                           hash);
    }

    public static boolean isConnected()
    {
        return jedis.isConnected();
    }

    public static Long setnx(byte[] key, byte[] value)
    {
        return jedis.setnx(key,
                           value);
    }

    public static Long sunionstore(String dstkey, String... keys)
    {
        return jedis.sunionstore(dstkey,
                                 keys);
    }

    public static String hget(String key, String field)
    {
        return jedis.hget(key,
                          field);
    }

    public static Long hincrBy(byte[] key, byte[] field, long value)
    {
        return jedis.hincrBy(key,
                             field,
                             value);
    }

    public static String set(byte[] key, byte[] value)
    {
        return jedis.set(key,
                         value);
    }

    public static List<byte[]> brpop(int timeout, byte[]... keys)
    {
        return jedis.brpop(timeout,
                           keys);
    }

    public static Long lrem(String key, long count, String value)
    {
        return jedis.lrem(key,
                          count,
                          value);
    }

    public static Long getDB()
    {
        return jedis.getDB();
    }

    public static Long lpushx(byte[] key, byte[] string)
    {
        return jedis.lpushx(key,
                            string);
    }

    public static Long dbSize()
    {
        return jedis.dbSize();
    }

    public static Long hlen(String key)
    {
        return jedis.hlen(key);
    }

    public static Long zremrangeByScore(String key, double start, double end)
    {
        return jedis.zremrangeByScore(key,
                                      start,
                                      end);
    }

    public static Long hsetnx(String key, String field, String value)
    {
        return jedis.hsetnx(key,
                            field,
                            value);
    }

    public static Long persist(byte[] key)
    {
        return jedis.persist(key);
    }

    public static String substr(String key, int start, int end)
    {
        return jedis.substr(key,
                            start,
                            end);
    }

    public static boolean getbit(String key, long offset)
    {
        return jedis.getbit(key,
                            offset);
    }

    public static String info()
    {
        return jedis.info();
    }

    public static byte[] getSet(byte[] key, byte[] value)
    {
        return jedis.getSet(key,
                            value);
    }

    public static Long lpushx(String key, String string)
    {
        return jedis.lpushx(key,
                            string);
    }

    public static Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count)
    {
        return jedis.zrangeByScoreWithScores(key,
                                             min,
                                             max,
                                             offset,
                                             count);
    }

    public static String configSet(String parameter, String value)
    {
        return jedis.configSet(parameter,
                               value);
    }

    public static List<String> hmget(String key, String... fields)
    {
        return jedis.hmget(key,
                           fields);
    }

    public static Set<byte[]> zrevrange(byte[] key, int start, int end)
    {
        return jedis.zrevrange(key,
                               start,
                               end);
    }

    public static Long expire(byte[] key, int seconds)
    {
        return jedis.expire(key,
                            seconds);
    }

    public static String spop(String key)
    {
        return jedis.spop(key);
    }

    public static Double zscore(String key, String member)
    {
        return jedis.zscore(key,
                            member);
    }

    public static List<String> sort(String key)
    {
        return jedis.sort(key);
    }

    public static Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count)
    {
        return jedis.zrevrangeByScoreWithScores(key,
                                                max,
                                                min,
                                                offset,
                                                count);
    }

    public static List<String> mget(String... keys)
    {
        return jedis.mget(keys);
    }

    public static Long decrBy(byte[] key, long integer)
    {
        return jedis.decrBy(key,
                            integer);
    }

    public static void monitor(JedisMonitor jedisMonitor)
    {
        jedis.monitor(jedisMonitor);
    }

    public static Map<byte[], byte[]> hgetAll(byte[] key)
    {
        return jedis.hgetAll(key);
    }

    public static String debug(DebugParams params)
    {
        return jedis.debug(params);
    }

    public static Set<byte[]> sdiff(byte[]... keys)
    {
        return jedis.sdiff(keys);
    }

    public static Long decrBy(String key, long integer)
    {
        return jedis.decrBy(key,
                            integer);
    }

    public static Long hdel(String key, String field)
    {
        return jedis.hdel(key,
                          field);
    }

    public static Set<String> zrevrangeByScore(String key, String max, String min)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min);
    }

    public static Long persist(String key)
    {
        return jedis.persist(key);
    }

    public static byte[] echo(byte[] string)
    {
        return jedis.echo(string);
    }

    public static Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max)
    {
        return jedis.zrangeByScoreWithScores(key,
                                             min,
                                             max);
    }

    public static Long zunionstore(byte[] dstkey, ZParams params, byte[]... sets)
    {
        return jedis.zunionstore(dstkey,
                                 params,
                                 sets);
    }

    public static Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min)
    {
        return jedis.zrevrangeByScoreWithScores(key,
                                                max,
                                                min);
    }

    public static Set<String> hkeys(String key)
    {
        return jedis.hkeys(key);
    }

    public static String mset(String... keysvalues)
    {
        return jedis.mset(keysvalues);
    }

    public static String slaveof(String host, int port)
    {
        return jedis.slaveof(host,
                             port);
    }

    public static Long zinterstore(String dstkey, ZParams params, String... sets)
    {
        return jedis.zinterstore(dstkey,
                                 params,
                                 sets);
    }

    public static Double zincrby(String key, double score, String member)
    {
        return jedis.zincrby(key,
                             score,
                             member);
    }

    public static Set<Tuple> zrangeWithScores(String key, int start, int end)
    {
        return jedis.zrangeWithScores(key,
                                      start,
                                      end);
    }

    public static Long setnx(String key, String value)
    {
        return jedis.setnx(key,
                           value);
    }

    public static List<String> hvals(String key)
    {
        return jedis.hvals(key);
    }

    public static Long zrem(byte[] key, byte[] member)
    {
        return jedis.zrem(key,
                          member);
    }

    public static Long smove(String srckey, String dstkey, String member)
    {
        return jedis.smove(srckey,
                           dstkey,
                           member);
    }

    public static boolean setbit(String key, long offset, boolean value)
    {
        return jedis.setbit(key,
                            offset,
                            value);
    }

    public static Set<String> zrevrangeByScore(String key, double max, double min)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min);
    }

    public static Set<String> smembers(String key)
    {
        return jedis.smembers(key);
    }

    public static String setex(String key, int seconds, String value)
    {
        return jedis.setex(key,
                           seconds,
                           value);
    }

    public static String save()
    {
        return jedis.save();
    }

    public static Long publish(String channel, String message)
    {
        return jedis.publish(channel,
                             message);
    }

    public static String rename(byte[] oldkey, byte[] newkey)
    {
        return jedis.rename(oldkey,
                            newkey);
    }

    public static Set<byte[]> smembers(byte[] key)
    {
        return jedis.smembers(key);
    }

    public static Long zremrangeByRank(String key, int start, int end)
    {
        return jedis.zremrangeByRank(key,
                                     start,
                                     end);
    }

    public static String rename(String oldkey, String newkey)
    {
        return jedis.rename(oldkey,
                            newkey);
    }

    public static Long lpush(byte[] key, byte[] string)
    {
        return jedis.lpush(key,
                           string);
    }

    public static String bgrewriteaof()
    {
        return jedis.bgrewriteaof();
    }

    public static List<String> brpop(int timeout, String... keys)
    {
        return jedis.brpop(timeout,
                           keys);
    }

    public static void connect()
    {
        jedis.connect();
    }

    public static Long lrem(byte[] key, int count, byte[] value)
    {
        return jedis.lrem(key,
                          count,
                          value);
    }

    public static Long hset(String key, String field, String value)
    {
        return jedis.hset(key,
                          field,
                          value);
    }

    public static String type(byte[] key)
    {
        return jedis.type(key);
    }

    public static long setrange(String key, long offset, String value)
    {
        return jedis.setrange(key,
                              offset,
                              value);
    }

    public static Long append(byte[] key, byte[] value)
    {
        return jedis.append(key,
                            value);
    }

    public static void subscribe(JedisPubSub jedisPubSub, String... channels)
    {
        jedis.subscribe(jedisPubSub,
                        channels);
    }

    public static String flushDB()
    {
        return jedis.flushDB();
    }

    public static List<byte[]> lrange(byte[] key, int start, int end)
    {
        return jedis.lrange(key,
                            start,
                            end);
    }

    public static String set(String key, String value)
    {
        return jedis.set(key,
                         value);
    }

    public static Long zunionstore(byte[] dstkey, byte[]... sets)
    {
        return jedis.zunionstore(dstkey,
                                 sets);
    }

    public static Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min,
                                      offset,
                                      count);
    }

    public static Long sdiffstore(String dstkey, String... keys)
    {
        return jedis.sdiffstore(dstkey,
                                keys);
    }

    public static Double zincrby(byte[] key, double score, byte[] member)
    {
        return jedis.zincrby(key,
                             score,
                             member);
    }

    public static String watch(String... keys)
    {
        return jedis.watch(keys);
    }

    public static String unwatch()
    {
        return jedis.unwatch();
    }

    public static Long strlen(byte[] key)
    {
        return jedis.strlen(key);
    }

    public static Long sort(byte[] key, byte[] dstkey)
    {
        return jedis.sort(key,
                          dstkey);
    }

    public static Long del(String... keys)
    {
        return jedis.del(keys);
    }

    public static String ltrim(String key, long start, long end)
    {
        return jedis.ltrim(key,
                           start,
                           end);
    }

    public static Boolean hexists(byte[] key, byte[] field)
    {
        return jedis.hexists(key,
                             field);
    }

    public static void sync()
    {
        jedis.sync();
    }

    public static Long zremrangeByRank(byte[] key, int start, int end)
    {
        return jedis.zremrangeByRank(key,
                                     start,
                                     end);
    }

    public static String lset(byte[] key, int index, byte[] value)
    {
        return jedis.lset(key,
                          index,
                          value);
    }

    public static Boolean hexists(String key, String field)
    {
        return jedis.hexists(key,
                             field);
    }

    public static Set<byte[]> zrevrangeByScore(byte[] key, double max, double min)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min);
    }

    public static Long zcard(byte[] key)
    {
        return jedis.zcard(key);
    }

    public static List<String> blpop(int timeout, String... keys)
    {
        return jedis.blpop(timeout,
                           keys);
    }

    public static Long zcard(String key)
    {
        return jedis.zcard(key);
    }

    public static byte[] rpoplpush(byte[] srckey, byte[] dstkey)
    {
        return jedis.rpoplpush(srckey,
                               dstkey);
    }

    public static List<Object> pipelined(PipelineBlock jedisPipeline)
    {
        return jedis.pipelined(jedisPipeline);
    }

    public static String type(String key)
    {
        return jedis.type(key);
    }

    public static Long strlen(String key)
    {
        return jedis.strlen(key);
    }

    public static List<byte[]> hmget(byte[] key, byte[]... fields)
    {
        return jedis.hmget(key,
                           fields);
    }

    public static String auth(String password)
    {
        return jedis.auth(password);
    }

    public static Long zrank(byte[] key, byte[] member)
    {
        return jedis.zrank(key,
                           member);
    }

    public static Long sinterstore(byte[] dstkey, byte[]... keys)
    {
        return jedis.sinterstore(dstkey,
                                 keys);
    }

    public static Set<String> zrangeByScore(String key, String min, String max)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max);
    }

    public static List<byte[]> sort(byte[] key, SortingParams sortingParameters)
    {
        return jedis.sort(key,
                          sortingParameters);
    }

    public static Long zadd(byte[] key, double score, byte[] member)
    {
        return jedis.zadd(key,
                          score,
                          member);
    }

    public static Long decr(byte[] key)
    {
        return jedis.decr(key);
    }

    public static String ltrim(byte[] key, int start, int end)
    {
        return jedis.ltrim(key,
                           start,
                           end);
    }

    public static Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min)
    {
        return jedis.zrevrangeByScore(key,
                                      max,
                                      min);
    }

    public static Set<byte[]> zrangeByScore(byte[] key, double min, double max)
    {
        return jedis.zrangeByScore(key,
                                   min,
                                   max);
    }

    public static Pipeline pipelined()
    {
        return jedis.pipelined();
    }

    public static byte[] srandmember(byte[] key)
    {
        return jedis.srandmember(key);
    }

    public static Long lpush(String key, String string)
    {
        return jedis.lpush(key,
                           string);
    }

    public static Long zrevrank(byte[] key, byte[] member)
    {
        return jedis.zrevrank(key,
                              member);
    }

    public static Long expireAt(String key, long unixTime)
    {
        return jedis.expireAt(key,
                              unixTime);
    }

    public static Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value)
    {
        return jedis.linsert(key,
                             where,
                             pivot,
                             value);
    }

    public static Long incr(byte[] key)
    {
        return jedis.incr(key);
    }

    public static String flushAll()
    {
        return jedis.flushAll();
    }

    public static Transaction multi()
    {
        return jedis.multi();
    }

    public static void psubscribe(BinaryJedisPubSub jedisPubSub, byte[]... patterns)
    {
        jedis.psubscribe(jedisPubSub,
                         patterns);
    }

    public static String randomKey()
    {
        return jedis.randomKey();
    }

    public static Long scard(byte[] key)
    {
        return jedis.scard(key);
    }

    public static String rpoplpush(String srckey, String dstkey)
    {
        return jedis.rpoplpush(srckey,
                               dstkey);
    }

    public static Set<byte[]> hkeys(byte[] key)
    {
        return jedis.hkeys(key);
    }

    public static Long zinterstore(byte[] dstkey, ZParams params, byte[]... sets)
    {
        return jedis.zinterstore(dstkey,
                                 params,
                                 sets);
    }

    public static Boolean sismember(String key, String member)
    {
        return jedis.sismember(key,
                               member);
    }

    public static Long msetnx(byte[]... keysvalues)
    {
        return jedis.msetnx(keysvalues);
    }

    public static Long getbit(byte[] key, long offset)
    {
        return jedis.getbit(key,
                            offset);
    }

    public static void subscribe(BinaryJedisPubSub jedisPubSub, byte[]... channels)
    {
        jedis.subscribe(jedisPubSub,
                        channels);
    }

    public static Set<Tuple> zrangeWithScores(byte[] key, int start, int end)
    {
        return jedis.zrangeWithScores(key,
                                      start,
                                      end);
    }

    public static Long srem(byte[] key, byte[] member)
    {
        return jedis.srem(key,
                          member);
    }

    public static Long llen(byte[] key)
    {
        return jedis.llen(key);
    }

    public static Long hlen(byte[] key)
    {
        return jedis.hlen(key);
    }

    public static Long move(byte[] key, int dbIndex)
    {
        return jedis.move(key,
                          dbIndex);
    }

    public static Set<byte[]> sinter(byte[]... keys)
    {
        return jedis.sinter(keys);
    }

    public static Long zcount(String key, double min, double max)
    {
        return jedis.zcount(key,
                            min,
                            max);
    }

    public static String getrange(byte[] key, long startOffset, long endOffset)
    {
        return jedis.getrange(key,
                              startOffset,
                              endOffset);
    }

    public static Long ttl(byte[] key)
    {
        return jedis.ttl(key);
    }

    public static Set<String> sinter(String... keys)
    {
        return jedis.sinter(keys);
    }
}
