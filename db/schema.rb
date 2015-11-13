# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20151113165318) do

  create_table "comments", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.integer  "post_id",    limit: 4
    t.text     "content",    limit: 65535
    t.integer  "likes",      limit: 4
    t.datetime "created_at",               null: false
    t.datetime "updated_at",               null: false
  end

  create_table "fellowships", force: :cascade do |t|
    t.integer  "u1_id",      limit: 4
    t.integer  "u2_id",      limit: 4
    t.datetime "created_at",           null: false
    t.datetime "updated_at",           null: false
  end

  create_table "friendships", force: :cascade do |t|
    t.integer  "u1_id",      limit: 4
    t.integer  "u2_id",      limit: 4
    t.boolean  "accepted",             default: false
    t.datetime "created_at",                           null: false
    t.datetime "updated_at",                           null: false
  end

  create_table "likes", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.integer  "status_id",  limit: 4
    t.datetime "created_at",           null: false
    t.datetime "updated_at",           null: false
  end

  create_table "posts", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.integer  "tag_id",     limit: 4
    t.datetime "created_at",           null: false
    t.datetime "updated_at",           null: false
  end

  create_table "recipes", force: :cascade do |t|
    t.integer  "user_id",     limit: 4
    t.integer  "post_id",     limit: 4
    t.integer  "votes",       limit: 4
    t.string   "description", limit: 255
    t.text     "preparation", limit: 65535
    t.datetime "created_at",                null: false
    t.datetime "updated_at",                null: false
  end

  create_table "statuses", force: :cascade do |t|
    t.integer  "user_id",     limit: 4
    t.integer  "post_id",     limit: 4
    t.integer  "likes",       limit: 4
    t.string   "description", limit: 255
    t.datetime "created_at",              null: false
    t.datetime "updated_at",              null: false
  end

  create_table "users", force: :cascade do |t|
    t.string   "f_name",        limit: 255
    t.string   "l_name",        limit: 255
    t.integer  "age",           limit: 4
    t.string   "city",          limit: 255
    t.string   "country",       limit: 255
    t.date     "date_of_birth"
    t.string   "gender",        limit: 1
    t.datetime "created_at",                null: false
    t.datetime "updated_at",                null: false
  end

  create_table "votes", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.integer  "recipe_id",  limit: 4
    t.integer  "value",      limit: 4
    t.datetime "created_at",           null: false
    t.datetime "updated_at",           null: false
  end

end