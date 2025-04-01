package com.example.voipdialer.utils

import android.text.TextUtils
import java.security.MessageDigest
import java.util.UUID


object CallManager {
    
     fun generateRoomString(callerId: String, calleeId: String): String{
         val ids: Array<String> = arrayOf(callerId, calleeId);
         val baseRoom = ids[0]+"_"+ids[1]

         return "https://meet.jit.si/${getSHA256Hash(baseRoom).substring(0, 20)}";
     }

    // For group calls with multiple participants
    fun generateGroupRoomName(participantIds: List<String?>?): String? {
        // Sort IDs to ensure consistency
//        Collections.sort(participantIds)  NO NEED


        // Create a unique room name
        val baseRoom = TextUtils.join("_", participantIds!!)
        val timestamp = System.currentTimeMillis().toString()

        return getSHA256Hash(baseRoom + "_" + timestamp).substring(0, 20)
    }


    private fun getSHA256Hash(s: String): String {
        val md = MessageDigest.getInstance("SHA-256")
//        val hash: ByteArray = md.digest(s.encodeToByteArray())

        try {
            md.update(s.encodeToByteArray());
            val hash: ByteArray = md.digest();
            StringBuilder().apply {
                for (b in hash) {
                    append(String.format("%02x", b))
                }
                return toString()
            }
        } catch (e: Exception) {
            return UUID.randomUUID().toString();
        }

    }


}