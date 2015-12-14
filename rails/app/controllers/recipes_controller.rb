class RecipesController < ApplicationController
	respond_to :json
	skip_before_filter  :verify_authenticity_token

	def index
		respond_with @posts = Recipe.all
	end

	def create
		@recipe = Recipe.new(recipe_params)
		@recipe.save
		respond_with @recipe
	end


private
    # Use callbacks to share common setup or constraints between actions.

    # Never trust parameters from the scary internet, only allow the white list through.
    def recipe_params
      params.require(:recipe).permit(:name, :description, :preparation)
    end

end